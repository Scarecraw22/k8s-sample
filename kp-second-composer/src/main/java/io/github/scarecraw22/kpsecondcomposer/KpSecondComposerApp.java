package io.github.scarecraw22.kpsecondcomposer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class KpSecondComposerApp {

    public static void main(String[] args) {
        SpringApplication.run(KpSecondComposerApp.class, args);
    }

}
