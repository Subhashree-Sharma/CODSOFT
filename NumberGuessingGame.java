import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomValue = new Random();
        boolean play = true;
        int totalAttempts = 0;
        int successfulRounds = 0;

        while (play) {
            totalAttempts++;
            if (playGame(inputScanner, randomValue)) {
                successfulRounds++;
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = inputScanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                play = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total attempts made: " + totalAttempts);
        System.out.println("Successful rounds: " + successfulRounds);
        System.out.println("Thanks for playing!");
        inputScanner.close();
    }

    public static boolean playGame(Scanner scanner, Random random) {
        int targetNum = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int maxTries = 5;
        int attempts = 0;

        while (attempts < maxTries) {
            System.out.print("Enter any guess value(between 1 and 100): ");
            int userGuess = scanner.nextInt();

            if (userGuess < targetNum) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNum) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number correctly: " + targetNum);
                return true; // Returns true if the user guessed correctly
            }

            attempts++;
        }

        System.out.println("Sorry, you have used all your attempts. The correct number was: " + targetNum);
        return false; // Returns false if the user couldn't guess correctly
    }
}