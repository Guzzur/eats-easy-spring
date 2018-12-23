package eatseasyspring.eatseasyspring.repository;

import java.util.*;

import eatseasyspring.eatseasyspring.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepo extends JpaRepository<Dish, Integer> {
    List<Dish> findDishesByRestaurant_RestaurantId(int restId);
}
