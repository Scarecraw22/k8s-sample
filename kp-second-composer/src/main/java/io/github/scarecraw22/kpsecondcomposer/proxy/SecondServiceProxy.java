package io.github.scarecraw22.kpsecondcomposer.proxy;

import io.github.scarecraw22.kpsecondcomposer.proxy.dto.SecondServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SecondServiceProxy {

    private final WebClient webClient;

    public Mono<SecondServiceDto> getSecondServiceResponse() {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/second-service/health-check").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(SecondServiceDto.class);
    }
}
