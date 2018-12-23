package eatseasyspring.eatseasyspring.service;

import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepo RestaurantRepository;
}
