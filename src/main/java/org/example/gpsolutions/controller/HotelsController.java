package org.example.gpsolutions.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.gpsolutions.constants.routs.HotelsControllerRouts;
import org.example.gpsolutions.converter.HotelConverter;
import org.example.gpsolutions.dto.request.HotelDto;
import org.example.gpsolutions.dto.request.HotelFullDto;
import org.example.gpsolutions.dto.request.PostHotelDto;
import org.example.gpsolutions.service.amenities.AmenitiesService;
import org.example.gpsolutions.service.hotel.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(HotelsControllerRouts.MAIN_ROUT)
public class HotelsController {
    private final HotelService hotelService;
    private final AmenitiesService amenitiesService;

    public HotelsController(HotelService hotelService, AmenitiesService amenitiesService) {
        this.hotelService = hotelService;
        this.amenitiesService = amenitiesService;
    }

    @Operation(summary = "Получение всех отелей"
            , description = "Возврат краткой информации всех отелей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"
                    , content = @Content(mediaType = "application/json", schema = @Schema(implementation = HotelDto.class))),
            @ApiResponse(responseCode = "404", description = "Не найден ресурс")
    })
    @GetMapping
    private List<HotelDto> getAll() {
        return HotelConverter.convertHotelsToDto(hotelService.getAll());
    }

    @Operation(summary = "Получение одного отеля"
            , description = "Возврат полной информации отеля по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"
                    , content = @Content(mediaType = "application/json", schema = @Schema(implementation = HotelFullDto.class))),
            @ApiResponse(responseCode = "404", description = "Не найден ресурс"),
            @ApiResponse(responseCode = "400", description = "Отеля с таким id не существует"),
    })
    @GetMapping(value = HotelsControllerRouts.PATH_ID)
    private HotelFullDto getHotel(
            @Parameter(description = "Id отеля для поиска", example = "1;20;1200;856")
            @PathVariable long id) {
        return HotelConverter.convertHotelToDto(hotelService.getById(id));
    }

    @Operation(summary = "Создание отеля"
            , description = "Создания отеля по отправленным данным")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное создание"
                    , content = @Content(mediaType = "application/json", schema = @Schema(implementation = HotelFullDto.class))),
            @ApiResponse(responseCode = "404", description = "Не найден ресурс"),
            @ApiResponse(responseCode = "400", description = "Не корректные данные, не получается распарсить Json/его нет"),
    })
    @PostMapping
    private HotelDto createHotel(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные отеля в формате json",
                    content = @Content(schema = @Schema(implementation = PostHotelDto.class)))
            @Valid @RequestBody PostHotelDto hotelDto) {
        return HotelConverter.convertHotelsToDto(Collections.singletonList(hotelService.save(HotelConverter.convertDtoToHotel(hotelDto)))).get(0);
    }

    @Operation(summary = "Обновление удобств"
            , description = "Обновление удобств по конкретному id и по списку удобств")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное обновление"
                    , content = @Content(mediaType = "application/json", schema = @Schema(implementation = HotelFullDto.class))),
            @ApiResponse(responseCode = "404", description = "Не найден ресурс"),
            @ApiResponse(responseCode = "400", description = "Не корректные данные, не получается распарсить Json/его нет"),
            @ApiResponse(responseCode = "500", description = "Проблема с обновлением")
    })
    @PostMapping(value = HotelsControllerRouts.PATH_AMENITIES_ID)
    private ResponseEntity<String> updateHotelAmenities(
            @Parameter(description = "Id отеля для изменения", example = "1;20;1200;856")
            @PathVariable long id,
            @Parameter(description = "Данные удобств", example = "[ \"Free parking\", \"Free WiFi\" ")
            @RequestBody List<String> amenities) {
        if (amenitiesService.updateHotelAmenities(amenities, id)) {
            return new ResponseEntity<>("Amenities added", HttpStatus.OK);
        }
        return new ResponseEntity<>("Problem with adding", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
