package com.example.evenement;

import com.example.evenement.Entities.Reclamation;
import com.example.evenement.Repositories.IReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class EvenementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvenementApplication.class, args);
    }
    @Autowired
    private IReclamationRepo reclamationRepo;

    @Bean
    ApplicationRunner init(){
        return (args) -> {
            reclamationRepo.save(new Reclamation());


            reclamationRepo.findAll().forEach(System.out::println);
        };
    }
}
