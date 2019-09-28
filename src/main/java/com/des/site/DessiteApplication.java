package com.des.site;

import com.des.site.config.PropertiesInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DessiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(DessiteApplication.class, args);
    }

    @Bean
    public PropertiesInitializer propertiesInitializer(){
        return new PropertiesInitializer();
    }

}
