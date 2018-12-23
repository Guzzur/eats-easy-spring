package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;


@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rest_id")
    private int restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "gps_point")
    private int gpsPoint;

    @Column(name = "address")
    private String address;

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

    public int getGpsPoint() {
        return gpsPoint;
    }

    public void setGpsPoint(int gpsPoint) {
        this.gpsPoint = gpsPoint;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
