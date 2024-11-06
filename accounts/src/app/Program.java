package app;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {

        Account acc = new Account(123, "Marco", 1250.00);
        BusinessAccount bacc = new BusinessAccount(255,"Sara",0.0,5000)

        //UPCASTING

        Account acc1 = bacc;
        acc1.getBalance();

        Account acc2 = new BusinessAccount(1560, "Jessica", 0.0, 360.0);
        Account acc3 = new SavingsAccount(236,"Ana",0.0,1000.0);

        //DOWNCASTING

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.00);

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.00);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Update!");
        }

    }
}
