package entities;

public class Account {

    private int number;
    private String holder;
    private double balance;

    /**
     * @Overload Constructor
     */

    public Account() {
    }

    public Account(int id, String name) {
        this.number = id;
        this.holder = name;
    }

    public Account(int id, String name, double initialDeposit) {
        this.number = id;
        this.holder = name;
        deposit(initialDeposit);
    }

    /**
     * Get and Set Methods
     */

    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Wallet operation
     */
    public void deposit(double amount) {
       balance += amount;
    }

    public void withdraw(double amount) {
       balance -= amount + 5.0;
    }

    /**
     * @return data from account
     */

    @Override
    public String toString() {
        return "Account: "
                + number + "\n"
                + "Holder: "
                + holder + "\n"
                + "Balance: "
                + String.format("%.2f", balance)
                + " €.";
    }
}
