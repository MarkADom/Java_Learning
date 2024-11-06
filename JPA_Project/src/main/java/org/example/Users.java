package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    private int usersId;
    private String name;

    public Users(){

    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
