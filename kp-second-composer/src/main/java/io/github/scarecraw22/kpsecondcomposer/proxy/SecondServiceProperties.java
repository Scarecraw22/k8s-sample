package io.github.scarecraw22.kpsecondcomposer.proxy;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kp")
record SecondServiceProperties(String secondServiceUrl) {
}
