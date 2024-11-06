package org.example;

import javax.persistence.*;

@Entity
public class Authors {

    @Id
    private int authorId;
    private String name;


    public Authors() {
    }

    public int getId() {
        return authorId;
    }

    public void setId(int id) {
        this.authorId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
