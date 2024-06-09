package org.example.gpsolutions.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "contacts")
@Schema(description = "Модель контактов отеля")
public class Contacts extends BaseEntity {
    @Schema(description = "Номер телефона", example = "+375443903949")
    private String phoneNumber;
    @Schema(description = "адрес электронной почты отеля", example = "robinson@gmail.com")
    @Email(message = "Электронная почта должна быть в таком виде emample@example.ru")
    private String email;
    @Schema(description = "Отель к которому относятся контакты по id", example = "1;15")
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
