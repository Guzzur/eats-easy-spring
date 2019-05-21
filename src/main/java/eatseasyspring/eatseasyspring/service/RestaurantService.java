package eatseasyspring.eatseasyspring.service;


import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo restRepo;
}
