package eatseasyspring.eatseasyspring.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;

@RequestMapping("/api/dishes")
@CrossOrigin(origins = "*")
@RestController
public class DishController {
    @Autowired
    private RestaurantRepo restRepo;

    @Autowired
    private DishRepo dishRepo;

    // GET routes
    @GetMapping(value = "")
    public List<Dish> getAllDishes() {
        return dishRepo.findAll();
    }

    @GetMapping(value = "/{dishId}")
    public Optional<Dish> getDishById(@PathVariable("dishId") int dishId) {
        return dishRepo.findById(dishId);
    }

    @GetMapping(value = "/menu/{restId}")
    public List<Dish> getMenu(@PathVariable("restId") int restId) {
        return dishRepo.findDishesByRestaurant_RestaurantId(restId);
    }

    // POST routes
    @PostMapping(value = "")
    public Dish addDish(@RequestBody Dish dish) {
        return dishRepo.save(dish);
    }
}
