package eatseasyspring.eatseasyspring.model;

import javax.persistence.*;



@Entity
@Table(name = "user")
public class User {


    @Id
    @Column(name = "userID")
    private int userID;


    @Column(name = "userName")
    private String userName;

}
