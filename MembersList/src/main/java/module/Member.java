package module;

import javafx.beans.property.SimpleStringProperty;

public class Member {

    SimpleStringProperty Name;
    SimpleStringProperty Phone;
    SimpleStringProperty Email;
    SimpleStringProperty Action;

    public Member(String name, String phone, String email, String action) {
        Name =  new SimpleStringProperty(name);
        Phone = new SimpleStringProperty(phone);
        Email = new SimpleStringProperty(email);
        Action = new SimpleStringProperty(action);
    }

    public String getName() {
        return Name.get();
    }

    public String getPhone() {
        return Phone.get();
    }

    public String getEmail() {
        return Email.get();
    }

    public String getAction() {
        return Action.get();
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public void setPhone(String phone) {
        this.Phone.set(phone);
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public void setAction(String action) {
        this.Action.set(action);
    }
}
