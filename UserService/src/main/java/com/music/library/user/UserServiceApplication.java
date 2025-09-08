package com.music.library.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// The @EnableEurekaClient annotation has been removed as it is now auto-configured.
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    // This Bean is used for making HTTP requests to other services
    @Bean
    @LoadBalanced // This tells Spring to use Eureka to resolve service names
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
