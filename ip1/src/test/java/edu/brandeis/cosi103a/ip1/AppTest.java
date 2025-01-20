package edu.brandeis.cosi103a.ip1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
public void testRollDice() {
    // Test rollDice method to ensure it returns values between 1 and 6
    for (int i = 0; i < 100; i++) {
        int roll = App.rollDice();
        // Correct usage of assertTrue
        assertTrue(roll >= 1 && roll <= 6);
    }
}

    @Test
    public void testWinnerDecision() {
        // Test a helper function that decides the winner
        int player1Score = 50;
        int player2Score = 40;
        String winner = getWinner(player1Score, player2Score);
        assertEquals("Player 1 wins!", winner);

        player1Score = 30;
        player2Score = 30;
        winner = getWinner(player1Score, player2Score);
        assertEquals("It's a tie!", winner);

        player1Score = 25;
        player2Score = 45;
        winner = getWinner(player1Score, player2Score);
        assertEquals("Player 2 wins!", winner);
    }

    // Helper method to decide the winner
    private String getWinner(int score1, int score2) {
        if (score1 > score2) {
            return "Player 1 wins!";
        } else if (score2 > score1) {
            return "Player 2 wins!";
        } else {
            return "It's a tie!";
        }
    }
}