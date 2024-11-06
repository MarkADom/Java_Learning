package app;

import entities.Account;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account account;


        // Input account details

        System.out.println("====== Account Details =======");

        System.out.print("Account number: ");
        int number = sc.nextInt();
        System.out.print("Account holder: ");
        //line used to consume space created with nextInt().
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.print("Is there a initial deposit (y/n)? ");
        char response = sc.next().charAt(0);
        if (response == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        } else {
            account = new Account(number, holder);
        }
        /*
         *Account details Output
         */

        System.out.println();
        System.out.println("Account data:");
        System.out.println(account);

        /*
         *Deposit Update Output
         */

        System.out.println();
        System.out.print("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println();
        System.out.println("Updated account data: ");
        System.out.println(account);

        /*
         *Withdraw Update Output
         */

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println();
        System.out.println("Updated account data: ");
        System.out.println(account);

        sc.close();
    }
}
