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


    List<Dish> findDishesByRestaurant_RestaurantId(int restID);


    //List<Dish> findDishesByRestaurant(Restaurant restaurant);
    //List<Dish> findDishesByRestaurant_RestaurantName(String name);
    //Iterable<Dish> findDishByRestaurant_RestaurantId(int restID);

//  @Query("select t FROM Dish AS t where t.Restaurantid = :id")
//    List<Dish> getAllMenuItemsFromRestaurantId(@Param("id") int id);
//List<Dish> findDishByRestaurant(int Restaurant);


  // List<Dish> findDishByRestaurantId(int RestaurantID);
   //Iterable<Dish> findDishByRestaurantId(int RestaurantID);

}
