package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;
        import java.sql.Date;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;


    //@ManyToOne
    @JoinColumn(name = "order_id")
    private int orderId;

    //@ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date_accepted")
    private Date dateAccepted;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateAccepted() {
        return dateAccepted;
    }

    public void setDateAccepted(Date dateAccepted) {
        this.dateAccepted = dateAccepted;
    }
}