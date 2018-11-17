package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;


@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dishID")
    private int restaurantId;

    @Column(name = "dishName")
    private String restaurantName;

    @ManyToOne
    @JoinColumn(name = "RestaurantId")
    private Restaurant restaurant;
}