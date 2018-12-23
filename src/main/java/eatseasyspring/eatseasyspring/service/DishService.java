package eatseasyspring.eatseasyspring.service;

import eatseasyspring.eatseasyspring.repository.DishRepo;
import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {
    @Autowired
    private RestaurantRepo RestaurantRepository;

    @Autowired
    private DishRepo DishRepository;
}




