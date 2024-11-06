import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Login {
    public static void main(String[] args) {

        System.out.println("Welcome to my login experience");

        Prompt prompt = new Prompt(System.in, System.out);

        StringInputScanner userName = new StringInputScanner();
        userName.setMessage("UserName: ");
        String name = prompt.getUserInput(userName);

        StringInputScanner password = new StringInputScanner();
        password.setMessage("Password: ");
        String pass = prompt.getUserInput(password);



        System.out.println("User's name: " + name + " | Password: " + pass);

    }
}
