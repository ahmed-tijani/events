package com.example.evennemntuser;

import com.example.evennemntuser.Entities.User;
import com.example.evennemntuser.Repositories.UserRepository;
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
public class EvennemntUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EvennemntUserApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            userRepository.save(new User(1,"Mariem", "Ch", "ma@esprit.tn"));
            userRepository.save(new User(2,"Sarra", "ab", "sa@esprit.tn"));
            userRepository.save(new User(3,"Mohamed", "ba", "mo@esprit.tn"));
// fetch
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
