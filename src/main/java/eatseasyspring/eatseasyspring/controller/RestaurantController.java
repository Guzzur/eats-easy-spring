package eatseasyspring.eatseasyspring.controller;

import java.util.*;

import eatseasyspring.eatseasyspring.model.Dish;
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
    @Autowired
    private DishRepo dishRepo;

    // GET routes
    @GetMapping(value = "restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }

    @GetMapping(value = "restaurants/{restId}")
    public Optional<Restaurant> getRestaurantById(@PathVariable("restId") int restId) {
        return restRepo.findById(restId);
    }

    @GetMapping(value = "restaurants/{restId}/menu")
    public List<Dish> getMenu(@PathVariable("restId") int restId) {
        return dishRepo.findDishesByRestId(restId);
    }

    // POST routes
    @PostMapping(value = "restaurants")
    public Restaurant addRest(@RequestBody Restaurant rest) {
        return restRepo.save(rest);
    }

}
