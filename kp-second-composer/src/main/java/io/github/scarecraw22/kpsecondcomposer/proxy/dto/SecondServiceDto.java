package io.github.scarecraw22.kpsecondcomposer.proxy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record SecondServiceDto(String message,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
                               LocalDateTime timestamp) {
}
