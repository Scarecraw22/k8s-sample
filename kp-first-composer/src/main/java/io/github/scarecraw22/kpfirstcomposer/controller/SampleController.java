package io.github.scarecraw22.kpfirstcomposer.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.scarecraw22.kpfirstcomposer.proxy.FirstServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequiredArgsConstructor
class SampleController {

    private final FirstServiceProxy firstServiceProxy;

    @GetMapping("/get-health-check")
    Mono<HealthCheckResponse> healthCheck() {
        return Mono.just(new HealthCheckResponse("Hello from First composer", LocalDateTime.now(ZoneId.of("UTC"))));
    }

    @PostMapping("/post-health-check")
    Mono<HealthCheckResponse> firstServiceHealthCheck() {
        return firstServiceProxy.getFirstServiceResponse()
                .map(dto -> new HealthCheckResponse(dto.message(), dto.timestamp()));
    }

    private record HealthCheckResponse(String message,
                                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
                                       LocalDateTime timestamp) {
    }
}
