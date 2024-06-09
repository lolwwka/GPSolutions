package org.example.gpsolutions.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(description = "Модель для фильтрации отелей по параметрам")
public class SearchDto {
    @Schema(description = "Параметр город для фильтрации", example = "Minsk")
    private String city;
    @Schema(description = "Параметр имя для фильтрации", example = "Minsk")
    private String name;
    @Schema(description = "Параметр бренд для фильтрации", example = "Minsk")
    private String brand;
    @Schema(description = "Параметр страна для фильтрации", example = "Minsk")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private Set<String> amenities;

    public SearchDto(String city, String name, String brand, String county, Set<String> amenities) {
        this.city = city;
        this.name = name;
        this.brand = brand;
        this.country = county;
        this.amenities = amenities;
    }

    public Set<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(Set<String> amenities) {
        this.amenities = amenities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

}
