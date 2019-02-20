
package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "calls_resolved")
public class CallResolve {
    @Id
    @SequenceGenerator(name = "calls_resolved_call_id_gen", sequenceName = "calls_resolved_call_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calls_resolved_call_id_gen")
    @Column(name = "call_resolve_id")
    private int callResolveId;

    //@ManyToOne
    @JoinColumn(name = "employee_id")
    private int employeeId;

    //@ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

    //@ManyToOne
    @JoinColumn(name = "call_id")
    private int callId;

    @Column(name = "call_resolve_date")
    private Date callResolveDate;

    public int getCallResolveId() {
        return callResolveId;
    }

    public void setCallResolveId(int callResolveId) {
        this.callResolveId = callResolveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public Date getCallResolveDate() {
        return callResolveDate;
    }

    public void setCallResolveDate(Date callResolveDate) {
        this.callResolveDate = callResolveDate;
    }
}