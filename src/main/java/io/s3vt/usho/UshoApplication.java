package io.s3vt.usho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UshoApplication {
    public static void main(String[] args) {
        SpringApplication.run(UshoApplication.class, args);
    }
}
