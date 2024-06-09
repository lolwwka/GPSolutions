package org.example.gpsolutions.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.gpsolutions.constants.routs.HistogramControllerRouts;
import org.example.gpsolutions.service.histogram.HistogramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(HistogramControllerRouts.MAIN_ROUT)
public class HistogramController {
    HistogramService histogramService;

    public HistogramController(HistogramService histogramService) {
        this.histogramService = histogramService;
    }

    @Operation(summary = "Группировка отсортированных отелей по значению указанного параметра по убыванию"
            , description = "Возвращает пару (параметр : количество) количество отелей соответствующих параметру")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешное выполнение"
                    , content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "Не найден ресурс"),
            @ApiResponse(responseCode = "400", description = "Не правильный параметр для поиска"),
    })
    @GetMapping(value = HistogramControllerRouts.GET_PARAM_ROUT)
    private Map<String, Long> getGroupedParams(
            @Parameter(description = "Параметр для группировки", example = "brand, city, county, amenities")
            @PathVariable String param) {
        return histogramService.countAndGroupByParam(param);
    }
}
