import java.util.Scanner;

public class ATM {
    private static double balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void checkBalance() {
        System.out.println("Your balance: RS." + balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: RS.");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful. New balance: RS." + balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: RS.");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient funds. Please try again.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: RS." + balance);
        }
    }
}
