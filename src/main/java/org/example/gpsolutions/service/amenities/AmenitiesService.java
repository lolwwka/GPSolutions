package org.example.gpsolutions.service.amenities;

import java.util.List;

public interface AmenitiesService {
    boolean updateHotelAmenities(List<String> amenities, long hotelId);
}
