package eatseasyspring.eatseasyspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class WhoAmIController {
    @RequestMapping(value = "/whoami", method = RequestMethod.GET)
    public String whoAmI(){
        return "Hello World!";
    }
}
