package org.example.gpsolutions.service.histogram;

import org.example.gpsolutions.dto.repository.CountDto;
import org.example.gpsolutions.exception.custom.BadRequestException;
import org.example.gpsolutions.repository.AddressRepository;
import org.example.gpsolutions.repository.AmenitiesRepository;
import org.example.gpsolutions.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HistogramServiceImpl implements HistogramService {
    private final HotelRepository hotelRepository;
    private final AddressRepository addressRepository;
    private final AmenitiesRepository amenitiesRepository;

    public HistogramServiceImpl(HotelRepository hotelRepository, AddressRepository addressRepository, AmenitiesRepository amenitiesRepository) {
        this.hotelRepository = hotelRepository;
        this.addressRepository = addressRepository;
        this.amenitiesRepository = amenitiesRepository;
    }

    @Override
    public Map<String, Long> countAndGroupByParam(String param) {
        List<CountDto> answer;
        answer = switch (param) {
            case "brand" -> hotelRepository.countAndGroupByBrand();
            case "city" -> addressRepository.countAndGroupByCity();
            case "country" -> addressRepository.countAndGroupByCountry();
            case "amenities" -> amenitiesRepository.countAndGroupByAmenities();
            default -> throw new BadRequestException("Incorrect histogram params");
        };
        return answer.stream()
                .sorted((x1, x2) -> x2.getCount().compareTo(x1.getCount()))
                .collect(Collectors.toMap(
                        CountDto::getLineName,
                        CountDto::getCount,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
