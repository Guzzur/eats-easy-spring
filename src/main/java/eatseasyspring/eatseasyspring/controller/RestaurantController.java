package eatseasyspring.eatseasyspring.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantRepo restRepo;

    @GetMapping(value = "restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }

    @GetMapping(value = "restaurants/{restId}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("restId") int restId) {
        return restRepo.findById(restId);
    }
}
