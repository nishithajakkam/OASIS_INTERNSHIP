import java.util.ArrayList;

public class BankAccount {
    private final User owner;
    private double balance;
    private final ArrayList<String> transactionHistory = new ArrayList<>();

    public BankAccount(User owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public User getOwner() {
        return owner;
    }

    public boolean verifyCredentials(String id, String pin) {
        return owner.getId().equals(id) && owner.getPin().equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposit: ₹" + String.format("%.2f", amount) + " | Balance: ₹" + String.format("%.2f", balance));
        System.out.println("Deposited ₹" + String.format("%.2f", amount) + ". New balance: ₹" + String.format("%.2f", balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        transactionHistory.add("Withdrawal: ₹" + String.format("%.2f", amount) + " | Balance: ₹" + String.format("%.2f", balance));
        System.out.println("Withdrew ₹" + String.format("%.2f", amount) + ". Remaining balance: ₹" + String.format("%.2f", balance));
        return true;
    }

    public boolean transfer(String receiverId, double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        transactionHistory.add("Transfer: ₹" + String.format("%.2f", amount) + " to " + receiverId + " | Balance: ₹" + String.format("%.2f", balance));
        System.out.println("Transferred ₹" + String.format("%.2f", amount) + " to " + receiverId + ". Remaining balance: ₹" + String.format("%.2f", balance));
        return true;
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }
}
