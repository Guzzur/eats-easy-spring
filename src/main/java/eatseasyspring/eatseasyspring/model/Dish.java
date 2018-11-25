package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dish_id")
    private int dishId;

    @Column(name = "dish_name")
    private String dishName;

    @ManyToOne
    @JoinColumn(name = "dish_restid")
    private Restaurant restaurant;
    //private int restId;

    public Dish() {
    }

    public Dish(String dishName, Restaurant restaurant) {
        this.dishName = dishName;
        this.restaurant = restaurant;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}