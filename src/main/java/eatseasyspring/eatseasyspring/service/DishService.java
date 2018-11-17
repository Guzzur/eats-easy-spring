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

   /* public List<Dish> getMenu(int restaurantId) {
        List<Dish> menu = new ArrayList<>();
        DishRepository.getAllMenuItemsFromRestaurantId(restaurantId).forEach(menu::add);
        return menu;
    }
*/

   public List<Dish> getMenu (int RestaurantID)
    {
        //List<Dish> menu = DishRepository.findDishByRestaurantId(RestaurantID);
        List<Dish> menu = DishRepository.findDishesByRestaurantId(RestaurantID);
        return menu;
    }
}
