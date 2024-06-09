package org.example.gpsolutions.converter;

import org.example.gpsolutions.dto.request.HotelDto;
import org.example.gpsolutions.dto.request.HotelFullDto;
import org.example.gpsolutions.dto.request.PostHotelDto;
import org.example.gpsolutions.entity.Address;
import org.example.gpsolutions.entity.ArrivalTime;
import org.example.gpsolutions.entity.Contacts;
import org.example.gpsolutions.entity.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelConverter {
    public static List<HotelDto> convertHotelsToDto(List<Hotel> hotels) {
        ArrayList<HotelDto> dtoArrayList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            HotelDto hotelDto = new HotelDto();
            hotelDto.setId(hotel.getId());
            hotelDto.setName(hotel.getName());
            hotelDto.setDescription(hotel.getDescription());
            hotelDto.setAddress(getFullAddress(hotel.getAddress()));
            hotelDto.setPhone(hotel.getContacts().getPhoneNumber());
            dtoArrayList.add(hotelDto);
        }
        return dtoArrayList;
    }

    private static String getFullAddress(Address address) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(address.getHouseNumber()).append(" ")
                .append(address.getStreet())
                .append(", ")
                .append(address.getCity())
                .append(", ")
                .append(address.getPostcode())
                .append(", ")
                .append(address.getCountry());
        return stringBuilder.toString();
    }

    public static HotelFullDto convertHotelToDto(Hotel hotel) {
        HotelFullDto hotelDto = new HotelFullDto();
        hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        Optional.ofNullable(hotel.getAddress())
                .ifPresent(address -> {
                    address.setHotel(null);
                    hotelDto.setAddress(address);
                });
        Optional.ofNullable(hotel.getContacts())
                .ifPresent(contacts -> {
                    contacts.setHotel(null);
                    hotelDto.setContacts(contacts);
                });
        Optional.ofNullable(hotel.getArrivalTime())
                .ifPresent(arrivalTime -> {
                    arrivalTime.setHotel(null);
                    hotelDto.setArrivalTime(arrivalTime);
                });
        Optional.ofNullable(hotel.getAmenitiesList())
                .ifPresent(amenitiesList -> {
                    amenitiesList.forEach(amenities -> amenities.setHotel(null));
                    hotelDto.setAmenities(amenitiesList);
                });
        return hotelDto;
    }

    public static Hotel convertDtoToHotel(PostHotelDto hotelDto) {
        Hotel hotel = new Hotel();
        Optional.ofNullable(hotelDto.getAddress()).ifPresent(addressDto -> {
            Address address = new Address();
            address.setHotel(hotel);
            Optional.ofNullable(addressDto.get("street")).ifPresent(address::setStreet);
            Optional.ofNullable(addressDto.get("postcode"))
                    .ifPresent(address::setPostcode);
            Optional.ofNullable(addressDto.get("city")).ifPresent(address::setCity);
            Optional.ofNullable(addressDto.get("country")).ifPresent(address::setCountry);
            Optional.ofNullable(addressDto.get("houseNumber"))
                    .map(Integer::parseInt)
                    .ifPresent(address::setHouseNumber);
            hotel.setAddress(address);
        });
        Optional.ofNullable(hotelDto.getName()).ifPresent(hotel::setName);
        Optional.ofNullable(hotelDto.getDescription()).ifPresent(hotel::setDescription);
        Optional.ofNullable(hotelDto.getBrand()).ifPresent(hotel::setBrand);
        Optional.ofNullable(hotelDto.getContacts()).ifPresent(contactsDto -> {
            Contacts contacts = new Contacts();
            contacts.setHotel(hotel);
            Optional.ofNullable(contactsDto.get("email")).ifPresent(contacts::setEmail);
            Optional.ofNullable(contactsDto.get("phone")).ifPresent(contacts::setPhoneNumber);
            hotel.setContacts(contacts);
        });
        Optional.ofNullable(hotelDto.getArrivalTime()).ifPresent(arrivalTimeDto -> {
            ArrivalTime arrivalTime = new ArrivalTime();
            arrivalTime.setHotel(hotel);
            Optional.ofNullable(arrivalTimeDto.get("checkIn")).ifPresent(arrivalTime::setCheckin);
            Optional.ofNullable(arrivalTimeDto.get("checkOut")).ifPresent(arrivalTime::setCheckout);
            hotel.setArrivalTime(arrivalTime);
        });
        return hotel;
    }
}
