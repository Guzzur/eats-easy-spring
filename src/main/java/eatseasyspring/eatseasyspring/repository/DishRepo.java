package eatseasyspring.eatseasyspring.repository;

import eatseasyspring.eatseasyspring.model.Dish;
import eatseasyspring.eatseasyspring.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface DishRepo extends JpaRepository<Dish,Integer> {

   // @Query("select t FROM Dish where t.RestaurantID = :id")
  //  List<Dish> getAllMenuItemsFromRestaurantId(@Param("id") int id);

    //List<Dish> findDishByRestaurantId(int RestaurantID);
    List<Dish> findDishesByRestaurantId(int RestaurantID);
}
