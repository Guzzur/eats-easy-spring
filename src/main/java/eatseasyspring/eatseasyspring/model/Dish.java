package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;

@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dishId;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name = "price")
    private float price;

    @Column(name = "dish_description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }
}