package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepo restRepo;

    @Autowired
    private DishRepo dishRepo;



    @GetMapping(value="restaurants")
    public Iterable<Restaurant> getAllRestaurants()
    {
        return restRepo.findAll();
    }



    @GetMapping(value="restaurants/menu/{id}")
    public List<Dish> getMenu(@PathVariable("id") int id) {
       return dishRepo.findDishesByRestaurant_RestaurantId(id);


       //return  dishRepo.findDishesByRestaurant_RestaurantName("Becky Please");
        //return dishRepo.findDishByRestaurant_RestaurantId(id);
    }

}
