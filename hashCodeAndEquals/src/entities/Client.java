package entities;

import java.util.Objects;

public class Client {

    private String name;
    private String email;


    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;

        if (!getName().equals(client.getName())) return false;
        return getEmail().equals(client.getEmail());
    }
}

