package com.example.pp_3_2_1_springboot;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Pp321SpringBootApplication {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Pp321SpringBootApplication.class, args);
    }

}
