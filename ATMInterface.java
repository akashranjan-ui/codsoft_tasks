import java.util.Scanner;

// BankAccount class
class BankAccount {

    private double balance;

    // Constructor
    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance = balance - amount;

        System.out.println("Withdrawal successful.");
        System.out.println("Amount withdrawn: ₹" + amount);

        return true;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;
        }

        balance = balance + amount;

        System.out.println("Deposit successful.");
        System.out.println("Amount deposited: ₹" + amount);

        return true;
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }
}


// ATM class
class ATM {

    private BankAccount account;

    // Constructor
    ATM(BankAccount account) {
        this.account = account;
    }

    // Display ATM menu
    public void showMenu() {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n============================");
            System.out.println("       ATM INTERFACE");
            System.out.println("============================");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.println("============================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 to 4.");
            }

        } while (choice != 4);

        sc.close();
    }

    // Withdraw method
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    // Deposit method
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + account.checkBalance());
    }
}


// Main class
public class ATMInterface {

    public static void main(String[] args) {

        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);

        // Connect ATM with bank account
        ATM atm = new ATM(account);

        // Start ATM
        atm.showMenu();
    }
}
