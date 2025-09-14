import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            User user = new User("Nishitha", "1234");
            BankAccount account = new BankAccount(user, 5000.0);

            ATMSystem atmSystem = new ATMSystem(sc);

            BankAccount loggedIn = null;
            while (loggedIn == null) {
                loggedIn = atmSystem.authenticate(account);
            }

            ATM atm = new ATM(loggedIn, sc);
            atm.showMenu();
        }
    }
}
