public class Client {

    private Wallet user = new Wallet();

    public Client(String name) {
    }

    public String deposit(double amount) {
        return "Account balance " + Bank.getBalance() + "\n" + "Deposit " + Bank.deposit(90 - Bank.getBalance());
    }

   public String withdraw(double amount) {
        return "Account balance " + Bank.getBalance() + "\n" +  Bank.withdraw(10 + Bank.getBalance());
    }

}
