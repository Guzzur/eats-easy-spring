package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;


@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurantid")
    private int restaurantId;


    @Column(name = "restaurantName")
    private String restaurantName;


    public String getRestaurantName() {
        return restaurantName;
    }
}
