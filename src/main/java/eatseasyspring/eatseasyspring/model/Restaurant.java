package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;

@Entity
@Table(name = "Restaurants")
public class Restaurant {
    @Id
    @SequenceGenerator(name="restaurants_rest_id_gen", sequenceName="restaurants_rest_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="restaurants_rest_id_gen")
    @Column(name = "rest_id")
    private int restaurantId;

    @Column(name = "rest_name")
    private String name;

    @Column(name = "rest_address")
    private String address;

    @Column(name = "rest_filterable_data")
    private RestFilterableData restFilterableData;

    public RestFilterableData getRestFilterableData() {
        return restFilterableData;
    }

    public void setRestFilterableData(RestFilterableData restFilterableData) {
        this.restFilterableData = restFilterableData;
    }


    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
