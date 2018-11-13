package eatseasyspring.eatseasyspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WhoAmIController {
    @GetMapping("/whoami")
    public String whoAmI(){
        return "Hello World!";
    }
}
