package eatseasyspring.eatseasyspring.service;

import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo RestaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return this.RestaurantRepository.findAll();
    }
}
