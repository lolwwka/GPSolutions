package org.example.gpsolutions.repository;

import org.example.gpsolutions.dto.repository.CountDto;
import org.example.gpsolutions.entity.Amenities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AmenitiesRepository extends JpaRepository<Amenities, Long> {
    @Query("select new org.example.gpsolutions.dto.repository.CountDto(e.name, count(e)) from Amenities e" +
            " group by e.name order by count(e) desc")
    List<CountDto> countAndGroupByAmenities();

    boolean existsAmenitiesByNameAndHotel_Id(String name, long hotelId);
}
