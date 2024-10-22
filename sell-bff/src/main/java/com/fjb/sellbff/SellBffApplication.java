package com.fjb.sellbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableWebFluxSecurity
public class SellBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellBffApplication.class, args);
    }

}
