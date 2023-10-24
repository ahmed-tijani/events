package com.example.evenementprojet;

import com.example.evenementprojet.Entities.Evenement;
import com.example.evenementprojet.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class EvenementProjetApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvenementProjetApplication.class, args);
    }
    @Autowired
    private EvenementRepository evenementRepository;
    @Bean
    ApplicationRunner init(){
        return  (args )->{
            evenementRepository.save(new Evenement());
            evenementRepository.findAll().forEach(System.out::println);
        };}
}
