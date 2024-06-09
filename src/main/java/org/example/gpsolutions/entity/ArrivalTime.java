package org.example.gpsolutions.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "arrival_time")
@Schema(description = "Модель временных значений отеля")
public class ArrivalTime extends BaseEntity {
    @Schema(description = "Время регистрации", example = "12:00")
    @Size(max = 5, min = 5, message = "Время приезда должно состоять из 5 символов пример 12:00")
    private String checkin;
    @Schema(description = "Время выезда", example = "13:00")
    @Size(max = 5, min = 5, message = "Время выезда должно состоять из 5 символов пример 12:00")
    private String checkout;
    @Schema(description = "Отель к которому относится модель времени по id", example = "1;15")
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
