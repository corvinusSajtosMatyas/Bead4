package com.sajtos.bead4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Bead4Application {

    public static void main(String[] args) {
        SpringApplication.run(Bead4Application.class, args);
        log.info("4. application started successfully.");
    }

}
