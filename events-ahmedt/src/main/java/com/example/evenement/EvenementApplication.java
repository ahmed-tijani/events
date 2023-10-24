package com.example.evenement;

import com.example.evenement.entities.Ticket;
import com.example.evenement.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class EvenementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvenementApplication.class, args);
    }
    @Autowired
    private TicketRepository repository;
    @Bean
    ApplicationRunner init() {
        return (args) -> {

        };
    }
}
