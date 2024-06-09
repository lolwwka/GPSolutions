package org.example.gpsolutions.repository.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.example.gpsolutions.dto.request.SearchDto;
import org.example.gpsolutions.entity.Address;
import org.example.gpsolutions.entity.Amenities;
import org.example.gpsolutions.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class HotelSpecification {
    public Specification<Hotel> build(SearchDto params) {
        return withBrand(params.getBrand())
                .and(withName(params.getName()))
                .and(withCountryAndCity(params.getCountry(), params.getCity()))
                .and(withAmenities(params.getAmenities()));
    }

    private Specification<Hotel> withBrand(String brand) {
        return (root, query, cb) -> brand == null ? cb.conjunction() : cb.equal(root.get("brand"), brand);
    }

    private Specification<Hotel> withName(String name) {
        return (root, query, cb) -> name == null ? cb.conjunction() : cb.equal(root.get("name"), name);
    }

    private Specification<Hotel> withCountryAndCity(String country, String city) {
        return (root, query, cb) -> {
            Join<Address, Hotel> addressHotelJoin = root.join("address");
            Predicate countryPredicate = country == null ? cb.conjunction() : cb.equal(addressHotelJoin.get("country"), country);
            Predicate cityPredicate = city == null ? cb.conjunction() : cb.equal(addressHotelJoin.get("city"), city);
            return cb.and(countryPredicate, cityPredicate);
        };
    }

    private Specification<Hotel> withAmenities(Set<String> amenities) {
        return (root, query, cb) -> {
            Join<Amenities, Hotel> amenitiesJoin = root.join("amenitiesList");
            Predicate amenitiesPredicate = null;
            if (amenities != null && !amenities.isEmpty()) {
                amenitiesPredicate = amenitiesJoin.get("name").in(amenities);
            }
            return amenitiesPredicate;
        };
    }
}
