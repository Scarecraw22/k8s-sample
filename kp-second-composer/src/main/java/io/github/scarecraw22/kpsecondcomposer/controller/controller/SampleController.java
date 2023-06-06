package io.github.scarecraw22.kpsecondcomposer.controller.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.scarecraw22.kpsecondcomposer.proxy.SecondServiceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
class SampleController {

    private final SecondServiceProxy secondServiceProxy;

    @GetMapping("/get-health-check")
    Mono<HealthCheckResponse> healthCheck() {
        return Mono.just(new HealthCheckResponse("Hello from second composer", LocalDateTime.now()));
    }

    @PostMapping("/post-health-check")
    Mono<HealthCheckResponse> secondServiceHealthCheck() {
        return secondServiceProxy.getSecondServiceResponse()
                .map(dto -> new HealthCheckResponse(dto.message(), dto.timestamp()));
    }

    private record HealthCheckResponse(String message,
                                       @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
                                       LocalDateTime timestamp) {
    }
}
