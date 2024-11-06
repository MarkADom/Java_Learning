package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publishers {

    @Id
    private int publisherId;
    private String name;

    public Publishers(){

    }

    public int getId() {
        return publisherId;
    }

    public void setId(int id) {
        this.publisherId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
