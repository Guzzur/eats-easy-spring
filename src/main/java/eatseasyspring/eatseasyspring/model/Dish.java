package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;


@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dishID")
    private int dishId;

    @Column(name = "dishName")
    private String dishName;

    @ManyToOne
    @JoinColumn(name = "RestaurantId")
    private Restaurant restaurant;
}