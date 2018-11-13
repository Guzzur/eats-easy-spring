package eatseasyspring.eatseasyspring.model;

import java.io.Serializable;

/*
JavaBean:
----------------------------------------------
1. Must have a public no-argument c'tor
2. 'Get', 'set' and 'is' for all attributes
3. Should implement the Serializable interface
 */

public class User implements Serializable {

    private long id;

    private String name;

    public User(){
        id=0;
    }

    public User(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
}