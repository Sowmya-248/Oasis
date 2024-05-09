import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER= 100;

    public static void main(String[] args) {
        Scanner number= new Scanner(System.in);
        Random rand= new Random();

        int targetNumber = rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ". Can you guess it?");

        while (true) {
            System.out.print("Enter your guess: ");
            int guess = getUserGuess(number);

            if (guess == targetNumber) {
                attempts++;
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " in " + attempts + " attempts.");
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
            attempts++;
        }
        
    }

    private static int getUserGuess(Scanner number) {
        while (true) {
            try {
                String input = number.nextLine();
                int guess = Integer.parseInt(input);
                if (guess < MIN_NUMBER|| guess > MAX_NUMBER) {
                    System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                    continue;
                }
                return guess;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
