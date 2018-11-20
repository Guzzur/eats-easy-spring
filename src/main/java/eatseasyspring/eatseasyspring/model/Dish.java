package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;


@Entity
@Table(name = "dish")
public class Dish {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dishid")
    private int dishid;

    @Column(name = "dish_name")
    private String dish_name;

    @ManyToOne
    @JoinColumn(name = "dish_restid")
    private Restaurant restaurant;


    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

}