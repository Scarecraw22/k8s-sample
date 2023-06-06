package io.github.scarecraw22.kpsecondcomposer.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
class SecondServiceConfiguration {

    @Bean
    SecondServiceProxy secondServiceProxy(SecondServiceProperties properties) {
        log.info("Second service url: {}", properties.secondServiceUrl());
        return new SecondServiceProxy(
                WebClient.builder()
                        .baseUrl(properties.secondServiceUrl())
                        .build()
        );
    }
}
