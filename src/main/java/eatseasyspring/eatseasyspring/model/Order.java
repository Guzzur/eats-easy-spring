package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Ordersdata")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_status")
    private int orderStatus;

    @Column(name = "time_received")
    private Date timeReceived;

    @Column(name = "time_delivered")
    private Date timeDelivered;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

    //@ManyToOne
    @JoinColumn(name = "table_id")
    private int tableId;

    //@ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(Date timeReceived) {
        this.timeReceived = timeReceived;
    }

    public Date getTimeDelivered() {
        return timeDelivered;
    }

    public void setTimeDelivered(Date timeDelivered) {
        this.timeDelivered = timeDelivered;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

