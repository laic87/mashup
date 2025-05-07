package org.laic.artistapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ArtistApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtistApiApplication.class, args);
    }

}
