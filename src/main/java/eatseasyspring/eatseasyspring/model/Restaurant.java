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

    @Column(name = "gps_lat")
    private float gpsLat;

    @Column(name = "gps_lon")
    private float gpsLon;

    @Column(name = "rest_type")
    private String restTypes;

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


    public float getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(float gpsLat) {
        this.gpsLat = gpsLat;
    }

    public float getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(float gpsLon) {
        this.gpsLon = gpsLon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRestTypes() {
        return restTypes;
    }

    public void setRestTypes(String restTypes) {
        this.restTypes = restTypes;

    }
}
