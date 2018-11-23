package eatseasyspring.eatseasyspring.service;

import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.model.Restaurant;
import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;



@Service
public class DishService {
    @Autowired
    private RestaurantRepo RestaurantRepository;
    @Autowired
    private DishRepo DishRepository;
}




