package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "shifts")
public class Shift {
    @Id
    @SequenceGenerator(name = "shifts_shift_id_gen", sequenceName = "shifts_shift_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shifts_shift_id_gen")
    @Column(name = "shift_id")
    private int shiftId;

    @Column(name = "starts_at")
    private Date startsAt;

    @Column(name = "ends_at")
    private Date endsAt;

    //@ManyToOne
    @JoinColumn(name = "rest_id")
    private int restId;

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public Date getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    public Date getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Date endsAt) {
        this.endsAt = endsAt;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }
}