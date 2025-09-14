
import java.util.Random;
import java.util.Scanner;

public class numberguessinggame {
    public static void main(String[] args) {
        Random rand = new Random();
        int num_to_guess = rand.nextInt(100) + 1; // Random number between 1–100
        int user_guess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100.");


        try (Scanner sc = new Scanner(System.in)) {
            while (user_guess != num_to_guess) {
                System.out.print("Enter your guess: ");
                user_guess = sc.nextInt();
                attempts++;

                if (user_guess == num_to_guess) {
                    System.out.println("Congratulations.......! You guessed it in " + attempts + " attempts.");
                } else if (user_guess < num_to_guess) {
                    System.out.println("It's too low,just try again....!");
                } else {
                    System.out.println("It's too high,just try again....!");
                }
            }
        }
    }
}
