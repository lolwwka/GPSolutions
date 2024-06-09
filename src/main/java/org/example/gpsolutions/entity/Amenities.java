package org.example.gpsolutions.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "amenities")
@Schema(description = "Модель удобств отеля")
public class Amenities extends BaseEntity {
    @Schema(description = "Наименование удобства", example = "Free WIFi, Free Parking")
    @NotBlank
    private String name;
    @Schema(description = "Отель к которому относится удобство по id", example = "1;15")
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Amenities() {
    }

    public Amenities(String name) {
        this.name = name;
    }
}
