package org.example.gpsolutions.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Модель передающая сообщения об ошибке", example = "Ошибка валидации")

public record ErrorMessage(String message) {

}
