package io.github.scarecraw22.kpfirstcomposer.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
class FirstServiceConfiguration {

    @Bean
    FirstServiceProxy firstServiceProxy(FirstServiceProperties properties) {
        log.info("First service url: {}", properties.firstServiceUrl());
        return new FirstServiceProxy(
                WebClient.builder()
                        .baseUrl(properties.firstServiceUrl())
                        .build()
        );
    }
}
