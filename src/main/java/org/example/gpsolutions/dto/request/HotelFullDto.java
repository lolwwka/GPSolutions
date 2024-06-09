package org.example.gpsolutions.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.gpsolutions.entity.Address;
import org.example.gpsolutions.entity.Amenities;
import org.example.gpsolutions.entity.ArrivalTime;
import org.example.gpsolutions.entity.Contacts;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Schema(description = "Модель хранящая всю информацию об отеле")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelFullDto {
    @Schema(description = "Id отеля в бд", example = "1;3;134")
    private long id;
    @Schema(description = "Имя отеля", example = "Robinson")
    private String name;
    @Schema(description = "Бренд отеля", example = "Hilton")
    private String brand;
    @Schema(description = "Полный адрес отеля", implementation = Address.class)

    private Address address;
    @Schema(description = "Полный список контактов отеля", implementation = Contacts.class)
    private Contacts contacts;
    @Schema(description = "Полный список времени регистраций отеля", implementation = ArrivalTime.class)
    private ArrivalTime arrivalTime;
    @Schema(description = "Полный список удобств отеля", implementation = Amenities.class)
    private Set<Amenities> amenities;
    @Schema(description = "Описание отеля")
    private String description;

    public long getId() {
        return id;
    }

    public HotelFullDto(long id, String name, String brand, Address address, Contacts contacts, ArrivalTime arrivalTime, Set<Amenities> amenities, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.address = address;
        this.contacts = contacts;
        this.arrivalTime = arrivalTime;
        this.amenities = amenities;
        this.description = description;
    }

    public HotelFullDto() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<String> getAmenities() {
        return amenities.stream().map(Amenities::getName).collect(Collectors.toList());
    }

    public Set<Amenities> getAmenties() {
        return amenities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmenities(Set<Amenities> amenities) {
        this.amenities = amenities;
    }

}