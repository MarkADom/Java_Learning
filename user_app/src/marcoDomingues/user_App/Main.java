package marcoDomingues.user_App;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LoginSystem lgs = new LoginSystem();

        User u1 = new User("a001", "MarkADom", "meca12", "Marco Domingues",
                "marco@gmail.com", "44", "male");
        User u2 = new User("a002", "MaryJane", "lebanon", "Maria Joana",
                "mariajoana@gmail.com", "32", "female");
        lgs.saveUser(u1);
        lgs.saveUser(u2);
        //System.out.println("User list: " + lgs.users);

        int menu;

        do {
            System.out.println("Select 1 for Login");
            System.out.println("Select 2 for SignIn");
            System.out.println("Select 3 to Exit");
            System.out.println("Select Option: ");
            menu = scanner.nextInt();

            if (menu == 1) {
                //proceed with login
                System.out.println("\nLogin in progress...");
                lgs.run();


            } else if (menu == 2) {
                //proceed with registration
                System.out.println("SignIn in progress\n");
            }
        } while (menu != 3);
    }


}
