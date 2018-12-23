package eatseasyspring.eatseasyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EatsEasySpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(EatsEasySpringApplication.class, args);
    }
}

// TODO:
// - Get all restaurants, filtered by area, restaurant type and working hours
// - Change <restaurants> gps_point to varchar
// - WTF is table_id column in <users>?!
// - Add input validation for each entry
