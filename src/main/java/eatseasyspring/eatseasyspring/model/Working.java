package eatseasyspring.eatseasyspring.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "working")
public class Working {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_id")
    private int workingId;

    //@ManyToOne
    @JoinColumn(name = "employee_id")
    private int employeeId;

    //@ManyToOne
    @JoinColumn(name = "shift_id")
    private int shiftId;

    public int getWorkingId() {
        return workingId;
    }

    public void setWorkingId(int workingId) {
        this.workingId = workingId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }
}