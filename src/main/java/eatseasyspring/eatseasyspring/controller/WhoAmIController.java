package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.WhoAmI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RequestMapping("/api/whoami")
@CrossOrigin(origins = "*")
@RestController
public class WhoAmIController {
    private WhoAmI version = new WhoAmI(0, 1, 2);

    @GetMapping(value = "")
    public WhoAmI getVersion() {
        return this.version;
    }
}
