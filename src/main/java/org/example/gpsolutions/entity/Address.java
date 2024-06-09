package org.example.gpsolutions.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
@Schema(description = "Модель адреса отеля")
public class Address extends BaseEntity {
    @Schema(description = "Номер дома", example = "51")
    private int HouseNumber;
    @Schema(description = "Улица", example = "Nemanskaya")
    private String street;
    @Schema(description = "Город", example = "Minsk")
    private String city;
    @Schema(description = "Страна", example = "Belarus")
    private String country;
    @Schema(description = "Почтовый индекс", example = "220000")
    private String postcode;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public Address() {
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
