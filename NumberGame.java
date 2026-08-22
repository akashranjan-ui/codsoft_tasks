import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("===== NUMBER GUESSING GAME =====");

        do {
            // Generate random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 7;
            boolean won = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            // Guessing loop
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    System.out.println("Attempts used: " + attempts);

                    // Score based on attempts
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Round Score: " + score);
                    won = true;
                    break;
                }

                else if (guess < number) {
                    System.out.println("Too Low! Try a higher number.");
                }

                else {
                    System.out.println("Too High! Try a lower number.");
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            // If player did not guess correctly
            if (!won) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("\nYour Total Score: " + totalScore);

            // Play another round
            System.out.print("\nDo you want to play another round? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\n===== GAME FINISHED =====");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}
