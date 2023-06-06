package io.github.scarecraw22.kpfirstcomposer.proxy;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kp")
record FirstServiceProperties(String firstServiceUrl) {
}
