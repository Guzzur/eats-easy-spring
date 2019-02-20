package eatseasyspring.eatseasyspring.model;

        import javax.persistence.*;
        import java.sql.Date;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @SequenceGenerator(name = "roles_role_id_gen", sequenceName = "roles_role_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_role_id_gen")
    @Column(name = "role_id")
    private int roleId;

    //@ManyToOne
    @JoinColumn(name = "user_id")
    private int userId;

    @Column(name = "role_name")
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}