package org.example.gpsolutions.service.hotel;

import org.example.gpsolutions.dto.request.SearchDto;
import org.example.gpsolutions.entity.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAll();

    Hotel getById(long id);

    List<Hotel> findByParam(SearchDto searchDto);

    Hotel save(Hotel hotel);
}
