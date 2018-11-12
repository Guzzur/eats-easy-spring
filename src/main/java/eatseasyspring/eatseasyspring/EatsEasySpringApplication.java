package eatseasyspring.eatseasyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"eatseasyspring.eatseasyspring"})
public class EatsEasySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatsEasySpringApplication.class, args);
    }
}
