package eatseasyspring.eatseasyspring.controller;


import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepo restRepo;



/*    @GetMapping(value="restaurants")
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restRepo.findAll();
        List<Restaurant> restaurants1 = restaurants;
        return restaurants1;
    }*/


    @GetMapping(value="restaurants")
    public Iterable<Restaurant> getAllRestaurants() {
        return restRepo.findAll();
    }



}
