package io.github.scarecraw22.kpfirstcomposer.proxy;

import io.github.scarecraw22.kpfirstcomposer.proxy.dto.FirstServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FirstServiceProxy {

    private final WebClient webClient;

    public Mono<FirstServiceDto> getFirstServiceResponse() {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/first-service/health-check").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(FirstServiceDto.class);
    }
}
