import java.util.Scanner;

public class ATM {
    private int balance;
    private String pin;

    public ATM(int balance, String pin) {
        this.balance = balance;
        this.pin = pin;
    }

    public void showMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Quit");
    }

    public void checkBalance(String pin) {
        if (this.pin.equals(pin)) {
            System.out.println("Your balance is: " + balance);
        } else {
            System.out.println("Incorrect PIN");
        }
    }

    public void withdraw(String pin, int amount) {
        if (this.pin.equals(pin)) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawing " + amount + ". Your new balance is: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Incorrect PIN");
        }
    }

    public void deposit(String pin, int amount) {
        if (this.pin.equals(pin)) {
            balance += amount;
            System.out.println("Depositing " + amount + ". Your new balance is: " + balance);
        } else {
            System.out.println("Incorrect PIN");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(10000, "1234");
        int choice;

        while (true) {
            atm.showMenu();
            System.out.print("Enter you Choice : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance("1234");
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    atm.withdraw("1234", withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    atm.deposit("1234", depositAmount);
                    break;
                case 4:
                    System.out.print("Thank you for using our ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}