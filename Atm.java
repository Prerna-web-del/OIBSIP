import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int balance = 5000;
        int pin = 1234;

        System.out.println("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != pin){
            System.out.println("Wrong PIN!");
            return;
        }

        while (true) {
                System.out.println("\n==== ATM MENU ====");
                System.out.println("1. Check Balance");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Exit");
                System.out.println("Choose Option: ");

                int Choice = sc.nextInt();

                switch (Choice) {

                    case 1: 
                    System.out.println("Your Balance: " + balance);
                    break;

                    case 2:
                    System.out.println("Enter amount to withdraw: ");
                   int withdraw = sc.nextInt();
                    if(withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Withdraw Successful!");
                    } else {
                    System.out.println("Insufficient Balance!");
                    }
                    break;

                    case 3:
                    System.out.println("Enter amount to deposit: ");
                   int deposit = sc.nextInt();
                    balance += deposit;
                    System.out.println("Deposit Successful!");
                    break;

                    case 4:
                    System.out.println("Thank you for using ATM!");
                    return;

                    default:
                        System.out.println("Invalid Option!");
            }
        }
    }
}

