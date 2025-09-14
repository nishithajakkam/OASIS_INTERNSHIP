import java.util.Scanner;

public class ATM {
    private final BankAccount account;
    private final Scanner sc;

    public ATM(BankAccount account, Scanner sc) {
        this.account = account;
        this.sc = sc;
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Choose an option (1-6): ");

            String choiceLine = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceLine);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number 1-6.");
                continue;
            }

            switch (choice) {
                case 1:
                    account.printTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wAmt = readAmount();
                    if (wAmt > 0) account.withdraw(wAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double dAmt = readAmount();
                    if (dAmt > 0) account.deposit(dAmt);
                    break;
                case 4:
                    System.out.print("Enter receiver ID: ");
                    String receiver = sc.nextLine().trim();
                    System.out.print("Enter amount to transfer: ");
                    double tAmt = readAmount();
                    if (tAmt > 0) account.transfer(receiver, tAmt);
                    break;
                case 5:
                    System.out.println("Current balance: ₹" + String.format("%.2f", account.getBalance()));
                    break;
                case 6:
                    System.out.println("Thank you. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private double readAmount() {
        String line = sc.nextLine().trim();
        try {
            double amt = Double.parseDouble(line);
            if (amt <= 0) {
                System.out.println("Enter amount greater than 0.");
                return -1;
            }
            return amt;
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Use numbers like 1000 or 250.50");
            return -1;
        }
    }
}
