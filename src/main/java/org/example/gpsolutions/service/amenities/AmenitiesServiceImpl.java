package org.example.gpsolutions.service.amenities;

import org.example.gpsolutions.entity.Amenities;
import org.example.gpsolutions.repository.AmenitiesRepository;
import org.example.gpsolutions.service.hotel.HotelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmenitiesServiceImpl implements AmenitiesService {
    private final AmenitiesRepository amenitiesRepository;
    private final HotelService hotelService;

    public AmenitiesServiceImpl(AmenitiesRepository amenitiesRepository, HotelService hotelService) {
        this.amenitiesRepository = amenitiesRepository;
        this.hotelService = hotelService;
    }

    @Override
    public boolean updateHotelAmenities(List<String> amenitiesListDto, long hotelId) {
        amenitiesListDto.removeIf(name -> amenitiesRepository.existsAmenitiesByNameAndHotel_Id(name, hotelId));
        amenitiesRepository.saveAll(convertAmenitiesDtoToAmenities(amenitiesListDto, hotelId));
        return true;
    }

    private List<Amenities> convertAmenitiesDtoToAmenities(List<String> amenitiesListDto, long hotelId) {
        List<Amenities> amenitiesList = new ArrayList<>();
        for (String x : amenitiesListDto) {
            Amenities amenities = new Amenities();
            amenities.setHotel(hotelService.getById(hotelId));
            amenities.setName(x);
            amenitiesList.add(amenities);
        }
        return amenitiesList;
    }
}
