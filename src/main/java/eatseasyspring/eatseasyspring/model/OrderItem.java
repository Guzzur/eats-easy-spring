package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orderitems")
public class OrderItem {
    @Id
    @SequenceGenerator(name = "orderitems_order_item_id_gen", sequenceName = "orderitems_order_item_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitems_order_item_id_gen")
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
}