package marcoDomingues.user_App;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem {
    ArrayList<User> users = new ArrayList<>();

    public boolean run() {

        //get user input
        Scanner keyboard = new Scanner(System.in);
        System.out.println("UserName: ");
        String inpUser = keyboard.nextLine();
        System.out.println("Password: ");
        String inPass = keyboard.nextLine();

        boolean loginSuccess = false;

        for (User temp : users) {
            if (inpUser.equals(temp.getUserName()) && inPass.equals(temp.getPassword())) {

                System.out.println("Welcome " + temp.getUserName()+"\n");
                loginSuccess = true;
                break;
            } else {
                loginSuccess = false;
            }
        }
        if (loginSuccess != true) {
            System.out.println("\nIncorrect Input, Try again.\n");
        }
        return loginSuccess;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
