package eatseasyspring.eatseasyspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WhoAmIController {
    String version = "V0.0.1";

    @GetMapping("/whoami")
    public String whoAmI(){
        return "{\"appName\": \"EatsEasyApi\", \"version\": \"" + version + "\"}";
    }
}
