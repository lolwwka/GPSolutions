//package org.example.gpsolutions;
//
//import org.example.gpsolutions.dto.repository.CountDto;
//import org.example.gpsolutions.exception.custom.BadRequestException;
//import org.example.gpsolutions.repository.AddressRepository;
//import org.example.gpsolutions.repository.AmenitiesRepository;
//import org.example.gpsolutions.repository.HotelRepository;
//import org.example.gpsolutions.service.histogram.HistogramServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//public class HistogramServiceTest {
//
//    @Mock
//    private HotelRepository hotelRepository;
//
//    @Mock
//    private AddressRepository addressRepository;
//
//    @Mock
//    private AmenitiesRepository amenitiesRepository;
//
//    @InjectMocks
//    private HistogramServiceImpl histogramService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testCountAndGroupByParam_Brand() {
//        List<CountDto> countDtoList = new ArrayList<>();
//        countDtoList.add(new CountDto("Brand1", 10L));
//        countDtoList.add(new CountDto("Brand2", 5L));
//        when(hotelRepository.countAndGroupByBrand()).thenReturn(countDtoList);
//        Map<String, Long> result = histogramService.countAndGroupByParam("brand");
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsKey("Brand1"));
//        assertTrue(result.containsKey("Brand2"));
//        assertEquals(10L, result.get("Brand1"));
//        assertEquals(5L, result.get("Brand2"));
//    }
//
//    @Test
//    public void testCountAndGroupByParam_InvalidParam() {
//        assertThrows(BadRequestException.class, () -> {
//            histogramService.countAndGroupByParam("invalidParam");
//        });
//    }
//    @Test
//    public void testCountAndGroupByParam_City() {
//        List<CountDto> countDtoList = new ArrayList<>();
//        countDtoList.add(new CountDto("City1", 15L));
//        countDtoList.add(new CountDto("City2", 8L));
//        when(addressRepository.countAndGroupByCity()).thenReturn(countDtoList);
//        Map<String, Long> result = histogramService.countAndGroupByParam("city");
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsKey("City1"));
//        assertTrue(result.containsKey("City2"));
//        assertEquals(15L, result.get("City1"));
//        assertEquals(8L, result.get("City2"));
//    }
//    @Test
//    public void testCountAndGroupByParam_Country() {
//        List<CountDto> countDtoList = new ArrayList<>();
//        countDtoList.add(new CountDto("Country1", 20L));
//        countDtoList.add(new CountDto("Country2", 12L));
//        when(addressRepository.countAndGroupByCountry()).thenReturn(countDtoList);
//
//        Map<String, Long> result = histogramService.countAndGroupByParam("country");
//
//        assertNotNull(result);
//        assertEquals(2, result.size());
//        assertTrue(result.containsKey("Country1"));
//        assertTrue(result.containsKey("Country2"));
//        assertEquals(20L, result.get("Country1"));
//        assertEquals(12L, result.get("Country2"));
//    }
//    @Test
//    public void testCountAndGroupByParam_Amenities() {
//        List<CountDto> countDtoList = new ArrayList<>();
//        countDtoList.add(new CountDto("WiFi", 30L));
//        countDtoList.add(new CountDto("Pool", 25L));
//        countDtoList.add(new CountDto("Gym", 18L));
//        when(amenitiesRepository.countAndGroupByAmenities()).thenReturn(countDtoList);
//        Map<String, Long> result = histogramService.countAndGroupByParam("amenities");
//        assertNotNull(result);
//        assertEquals(3, result.size());
//        assertTrue(result.containsKey("WiFi"));
//        assertTrue(result.containsKey("Pool"));
//        assertTrue(result.containsKey("Gym"));
//        assertEquals(30L, result.get("WiFi"));
//        assertEquals(25L, result.get("Pool"));
//        assertEquals(18L, result.get("Gym"));
//    }
//}
//
