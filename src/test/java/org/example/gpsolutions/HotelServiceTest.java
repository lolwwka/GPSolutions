package org.example.gpsolutions;

import org.example.gpsolutions.entity.Hotel;
import org.example.gpsolutions.exception.custom.IncorrectIdException;
import org.example.gpsolutions.repository.HotelRepository;
import org.example.gpsolutions.repository.specification.HotelSpecification;
import org.example.gpsolutions.service.hotel.HotelServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private HotelSpecification hotelSpecification;

    @InjectMocks
    private HotelServiceImpl hotelService;

    public HotelServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Hotel1"));
        hotels.add(new Hotel("Hotel2"));
        when(hotelRepository.findAll()).thenReturn(hotels);
        List<Hotel> result = hotelService.getAll();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetById_ExistingId() {
        Hotel hotel = new Hotel("Hotel1");
        hotel.setId(1L);
        when(hotelRepository.findById(1L)).thenReturn(Optional.of(hotel));
        Hotel result = hotelService.getById(1L);
        assertNotNull(result);
        assertEquals(hotel, result);
    }

    @Test
    public void testGetById_NonExistingId() {
        when(hotelRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IncorrectIdException.class, () -> {
            hotelService.getById(1L);
        });
    }

    @Test
    public void testSave() {
        Hotel hotel = new Hotel("Hotel1");
        when(hotelRepository.save(hotel)).thenReturn(hotel);
        Hotel result = hotelService.save(hotel);
        assertNotNull(result);
        assertEquals(hotel, result);
    }
}

