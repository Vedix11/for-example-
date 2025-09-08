package com.music.library.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// The @EnableEurekaClient annotation has been removed as it is auto-configured
@SpringBootApplication
@EnableConfigServer // This enables the application to act as a configuration server
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
