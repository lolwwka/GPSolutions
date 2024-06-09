package org.example.gpsolutions.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.gpsolutions.entity.Address;
import org.example.gpsolutions.entity.ArrivalTime;

import java.util.Map;

@Schema(description = "Модель добавления отеля в бд")
public class PostHotelDto {
    @Schema(description = "Id отеля в бд", example = "1;3;134")

    private long id;
    @Schema(description = "Имя отеля", example = "Robinson")
    private String name;
    @Schema(description = "Бренд отеля", example = "Hilton")
    private String brand;
    @Schema(description = "Полный адрес отеля в виде хэш таблицы")
    private Map<String, String> address;
    @Schema(description = "Полный список контактов отеля в виде хэш таблицы")
    private Map<String, String> contacts;
    @Schema(description = "Полный список времён регистрации отеля в виде хэш таблицы")
    private Map<String, String> arrivalTime;
    @Schema(description = "Описание отеля")

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public Map<String, String> getContacts() {
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {
        this.contacts = contacts;
    }

    public Map<String, String> getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Map<String, String> arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}