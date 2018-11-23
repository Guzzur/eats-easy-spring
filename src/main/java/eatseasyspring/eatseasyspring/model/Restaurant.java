package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;


@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rest_id")
    private int restaurantId;


    @Column(name = "restaurantName")
    private String restaurantName;


    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
