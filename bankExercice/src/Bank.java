public class Bank {



    private String accountName;
    private static double balance = 1000;

    public static double getBalance() {
        return balance;
    }

    public static String deposit(double amount) {
        balance = balance + amount;
        return "New account balance " + balance;
    }

    public static String withdraw(double amount) {
        balance = balance - amount;
        return "New account balance " + balance;
    }

}



