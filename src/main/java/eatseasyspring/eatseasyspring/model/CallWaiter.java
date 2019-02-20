package eatseasyspring.eatseasyspring.model;

        import javax.persistence.*;
        import java.sql.Date;

@Entity
@Table(name = "calls_for_waiter")
public class CallWaiter {
    @Id
    @SequenceGenerator(name = "calls_for_waiter_call_id_gen", sequenceName = "calls_for_waiter_call_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calls_for_waiter_call_id_gen")
    @Column(name = "call_id")
    private int callId;

    //@ManyToOne
    @JoinColumn(name = "table_id")
    private int tableId;

    //@ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "call_date")
    private Date callDate;

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
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

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }
}