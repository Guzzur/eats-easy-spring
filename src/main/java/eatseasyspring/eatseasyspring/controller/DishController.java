package eatseasyspring.eatseasyspring.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.repository.DishRepo;

@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RestController
public class DishController {
    @Autowired
    private DishRepo dishRepo;

    // GET routes
    @GetMapping(value = "dishes")
    public List<Dish> getAllDishes() {
        return dishRepo.findAll();
    }

    @GetMapping(value = "dishes/{dishId}")
    public Optional<Dish> getDishById(@PathVariable("dishId") int dishId) {
        return dishRepo.findById(dishId);
    }

    // POST routes
    @PostMapping(value = "dishes")
    public Dish addDish(@RequestBody Dish dish) {
        return dishRepo.save(dish);
    }

    // PUT routes
    @PutMapping(value = "dishes/{dishId}")
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dish, @PathVariable int dishId) {
        Optional<Dish> dishOptional = dishRepo.findById(dishId);

        if(!dishOptional.isPresent())
            return ResponseEntity.notFound().build();

        dish.setDishId(dishId);
        dishRepo.save(dish);

        return ResponseEntity.ok(dish);
    }

    // DELETE routes
    @DeleteMapping(value = "dishes/{dishId}")
    public void deleteDish(@PathVariable int dishId) {
        dishRepo.deleteById(dishId);
    }
}
