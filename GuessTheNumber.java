import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 5;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");

        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;

        boolean guessedCorrectly = false;
        int attempts = 0;

        while (!guessedCorrectly && attempts < MAX_ATTEMPTS) {
            String input = JOptionPane.showInputDialog("Enter your guess (between "
                    + MIN_NUMBER + " and " + MAX_NUMBER + "):");

            if (input == null) {
                JOptionPane.showMessageDialog(null, "Game aborted!");
                return;
            }

            try {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                    JOptionPane.showMessageDialog(null, "Please enter a number between "
                            + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                    continue;
                }

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    score += MAX_ATTEMPTS - attempts + 1;
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in "
                            + attempts + " attempts.\nYour current score is: " + score);
                } else if (guess < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Try a higher number.");
                } else {
                    JOptionPane.showMessageDialog(null, "Try a lower number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        }

        if (!guessedCorrectly) {
            JOptionPane.showMessageDialog(null, "Sorry, you didn't guess the number. It was " + randomNumber
                    + "\nYour final score is: " + score);
        }
    }
}
