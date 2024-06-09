package org.example.gpsolutions.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "hotel")
@Schema(description = "Модель отеля")
public class Hotel extends BaseEntity {
    @Schema(description = "Имя отеля", example = "Robinson")
    private String name;
    @Schema(description = "Бренд отеля", example = "Hilton")
    private String brand;
    @Schema(description = "Описание отеля")
    private String description;

    @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Address address;
    @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Contacts contacts;
    @OneToOne(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private ArrivalTime arrivalTime;

    @OneToMany(mappedBy = "hotel")
    private Set<Amenities> amenitiesList;

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

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Set<Amenities> getAmenitiesList() {
        return amenitiesList;
    }

    public void setAmenitiesList(Set<Amenities> amenitiesList) {
        this.amenitiesList = amenitiesList;
    }

    public Hotel() {
    }

    public Hotel(String name) {
        this.name = name;
    }
}
