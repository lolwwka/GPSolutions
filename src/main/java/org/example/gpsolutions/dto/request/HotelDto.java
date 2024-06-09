package org.example.gpsolutions.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель передающая краткую информацию от отеле")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDto {
    @Schema(description = "Id отеля в бд", example = "1;3;134")
    private long id;
    @Schema(description = "Имя отеля", example = "Robinson")
    private String name;
    @Schema(description = "Описание отеля")
    private String description;
    @Schema(description = "Короткий адрес отеля", example = "9 Pobediteley Avenue, Minsk, 220004, Belarus")
    private String address;
    @Schema(description = "Номер отеля", example = "+375443903949")
    private String phone;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
