package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepo restRepo;

    @Autowired
    private DishRepo dishRepo;

    @GetMapping(value = "restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }

    @GetMapping(value = "restaurants/{id}/menu")
    public List<Dish> getMenu(@PathVariable("id") int id) {
        return dishRepo.findDishesByRestaurant_RestaurantId(id);
    }

    //this is a template of how we could potentially add an instance to a table
    //using a non default constructor would be quicker
    @PostMapping(value = "restaurants/{id}/dish")
    public Dish addDish(@PathVariable("id") int id, @RequestBody Dish dish) {
        Optional<Restaurant> rest = restRepo.findById(id);
        return dishRepo.save(dish);
    }
}
