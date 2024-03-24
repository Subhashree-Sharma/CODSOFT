import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the bank account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance of the bank account
    public double getBalance() {
        return balance;
    }

    // Method to deposit funds into the bank account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw funds from the bank account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice acc to a given number: ");
    }

    // Method to execute the ATM functionality
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: " + bankAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextDouble();
                    bankAccount.deposit(amount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextDouble();
                    if (bankAccount.withdraw(amount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

public class ATM_INTERFACE {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of 1000
        BankAccount bankAccount = new BankAccount(1000);
        
        // Initialize the ATM with the bank account and run it
        ATM atm = new ATM(bankAccount);
        atm.run();
    }
}

