package eatseasyspring.eatseasyspring.service;

import eatseasyspring.eatseasyspring.repository.RestaurantRepo;
import eatseasyspring.eatseasyspring.repository.TableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    @Autowired
    private RestaurantRepo restRepo;

    @Autowired
    private TableRepo tableRepo;
}
