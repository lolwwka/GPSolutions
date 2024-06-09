package org.example.gpsolutions.service.hotel;

import org.example.gpsolutions.dto.request.SearchDto;
import org.example.gpsolutions.entity.Hotel;
import org.example.gpsolutions.exception.custom.IncorrectIdException;
import org.example.gpsolutions.repository.HotelRepository;
import org.example.gpsolutions.repository.specification.HotelSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelSpecification hotelSpecification;

    public HotelServiceImpl(HotelRepository hotelRepository, HotelSpecification hotelSpecification) {
        this.hotelSpecification = hotelSpecification;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new IncorrectIdException("Hotel with that id doesn't exist"));
    }

    @Override
    public List<Hotel> findByParam(SearchDto searchDto) {
        return hotelRepository.findAll(hotelSpecification.build(searchDto));
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
