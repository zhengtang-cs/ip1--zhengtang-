package edu.brandeis.cosi103a.ip1;

/**
 * Hello world!
 *
 */
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[2]; // Scores for the two players
        int turns = 10; // Each player gets 10 turns

        System.out.println("Welcome to the Dice Game!");
        for (int round = 1; round <= turns; round++) {
            for (int player = 0; player < 2; player++) {
                System.out.println("Player " + (player + 1) + "'s turn:");
                int roll = rollDice();
                System.out.println("You rolled a " + roll);

                // Allow up to 2 rerolls
                for (int reroll = 0; reroll < 2; reroll++) {
                    System.out.println("Do you want to re-roll? (yes/no)");
                    String choice = scanner.next();
                    if (choice.equalsIgnoreCase("yes")) {
                        roll = rollDice();
                        System.out.println("You rolled a " + roll);
                    } else {
                        break;
                    }
                }
                // Add the dice value to the player's score
                scores[player] += roll;
                System.out.println("Your total score is now: " + scores[player]);
            }
        }

        // Print final scores and determine the winner
        System.out.println("Game Over!");
        System.out.println("Player 1's score: " + scores[0]);
        System.out.println("Player 2's score: " + scores[1]);
        if (scores[0] > scores[1]) {
            System.out.println("Player 1 wins!");
        } else if (scores[1] > scores[0]) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();
    }

    // Simulate rolling a 6-sided dice
    public static int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
