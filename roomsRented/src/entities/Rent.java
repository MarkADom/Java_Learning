package entities;

public class Rent {

    private String names;
    private String email;

    public Rent() {
    }

    public Rent(String names, String email) {
        this.names = names;
        this.email = email;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
