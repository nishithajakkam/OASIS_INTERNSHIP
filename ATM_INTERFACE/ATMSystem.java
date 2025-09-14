import java.util.Scanner;

public class ATMSystem {
    private final Scanner sc;

    public ATMSystem(Scanner sc) {
        this.sc = sc;
    }

    public BankAccount authenticate(BankAccount account) {
        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine().trim();
        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine().trim();

        if (account.verifyCredentials(enteredId, enteredPin)) {
            System.out.println("Login successful! Welcome, " + account.getOwner().getId() + ".");
            return account;
        } else {
            System.out.println("Invalid ID or PIN. Please try again.\n");
            return null;
        }
    }
}
