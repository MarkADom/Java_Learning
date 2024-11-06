public class Main {
    public static void main(String[] args) {

        Client client = new Client("Jimmy");
        //System.out.println(Bank.getBalance());
        System.out.println(client);
        System.out.println(client.deposit(0));
        System.out.println(client.withdraw(0));

    }
}