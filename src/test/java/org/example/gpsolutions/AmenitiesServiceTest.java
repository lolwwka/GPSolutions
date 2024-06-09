//package org.example.gpsolutions;
//
//import org.example.gpsolutions.entity.Hotel;
//import org.example.gpsolutions.repository.AmenitiesRepository;
//import org.example.gpsolutions.service.amenities.AmenitiesServiceImpl;
//import org.example.gpsolutions.service.hotel.HotelService;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.*;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.mockito.ArgumentMatchers.any;
//
//@ExtendWith(MockitoExtension.class)
//public class AmenitiesServiceTest {
//    @Mock
//    private static AmenitiesRepository amenitiesRepository;
//    @Mock
//    private static HotelService hotelService;
//    @InjectMocks
//    private static AmenitiesServiceImpl amenitiesService;
//
//    @BeforeClass
//    public static void setUp() {
//        Hotel hotel = new Hotel();
//        hotel.setId(1L);
//        when(hotelService.getById(1L)).thenReturn(hotel);
//    }
//
//    @Test
//    void testUpdateHotelAmenities() {
//        List<String> amenitiesListDto = new LinkedList<>(Arrays.asList("WiFi", "Pool", "Gym"));
//        when(amenitiesRepository.existsAmenitiesByNameAndHotel_Id("WiFi", 1L)).thenReturn(true);
//        when(amenitiesRepository.existsAmenitiesByNameAndHotel_Id("Pool", 1L)).thenReturn(false);
//        when(amenitiesRepository.existsAmenitiesByNameAndHotel_Id("Gym", 1L)).thenReturn(false);
//        boolean result = amenitiesService.updateHotelAmenities(amenitiesListDto, 1L);
//        Assertions.assertTrue(result);
//        verify(amenitiesRepository, times(1)).saveAll(any(List.class));
//        verify(amenitiesRepository, times(1)).existsAmenitiesByNameAndHotel_Id("WiFi", 1L);
//        verify(amenitiesRepository, times(1)).existsAmenitiesByNameAndHotel_Id("Pool", 1L);
//        verify(amenitiesRepository, times(1)).existsAmenitiesByNameAndHotel_Id("Gym", 1L);
//    }
//}
