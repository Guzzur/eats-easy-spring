package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orderitems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private int orderItemId;


    //@ManyToOne
    @JoinColumn(name = "order_id")
    private int orderId;

    //@ManyToOne
    @JoinColumn(name = "dish_id")
    private int dishId;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "subtotal")
    private double subtotal;

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}