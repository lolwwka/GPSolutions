package org.example.gpsolutions.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.gpsolutions.constants.routs.SearchControllerRouts;
import org.example.gpsolutions.converter.HotelConverter;
import org.example.gpsolutions.dto.request.HotelDto;
import org.example.gpsolutions.dto.request.SearchDto;
import org.example.gpsolutions.service.hotel.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(SearchControllerRouts.MAIN_ROUT)
public class SearchController {
    private final HotelService hotelService;

    public SearchController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Operation(summary = "Фильтрация отелей"
            , description = "Фильтрация по какому-то фильтру или их совокупности, допустимые параметры : " +
            "name, brand, city, county, amenities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный поиск"
                    , content = @Content(mediaType = "application/json", schema = @Schema(implementation = HotelDto.class))),
            @ApiResponse(responseCode = "404", description = "Не найден ресурс"),
            @ApiResponse(responseCode = "400", description = "Не корректные данные, не получается распарсить Json/его нет"),
    })
    @GetMapping
    public List<HotelDto> searchHotel(
            @Parameter(description = "Параметры для фильтрации", example = "search?amenities=Free WiFi&city=Minsk")
            SearchDto searchDto) {
        return HotelConverter.convertHotelsToDto(hotelService.findByParam(searchDto));
    }
}
