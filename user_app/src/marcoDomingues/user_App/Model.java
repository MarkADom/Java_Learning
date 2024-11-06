package marcoDomingues.user_App;

import java.util.HashMap;

public class Model {

    //create hashmap for storing information about users

    private static HashMap<String, User> users = new HashMap<String, User>();

    public static HashMap<String, User> getUsers() {
        return users;
    }

    public static void setUsers(HashMap<String, User> users) {
        Model.users = users;
    }
}
