package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.WhoAmI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class WhoAmIController {
    private WhoAmI version = new WhoAmI(0, 1, 5);

    @GetMapping(value = "whoami")
    public WhoAmI getVersion() {
        return this.version;
    }
}
