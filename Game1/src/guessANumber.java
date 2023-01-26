import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class guessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int computerRandom = randomNumber.nextInt(100);
        int playerNumber = 0;
        int counter = 0;
        int maxAttempts = 7;

        while (computerRandom != playerNumber) {
            if (counter > 7) {
                break;
            }
            System.out.print("Guess s number (1-100): ");
            String playerInput = scanner.nextLine();
            counter++;
            boolean isValid = true;
            for (int i = 0; i < playerInput.length(); i++) {
                if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                    isValid = false;
                }
            }
            if (isValid) {
                playerNumber = Integer.parseInt(playerInput);
                if (counter == 7 && playerNumber != computerRandom) {
                    System.out.printf("Game over! You make a seven attempts but could not guess the number %d!%n", computerRandom);
                    break;
                }
                if (playerNumber == computerRandom) {
                    System.out.printf("You guessed it from %d time!", counter);
                    break;
                } else if (playerNumber < computerRandom && playerNumber > 0) {
                    System.out.printf("Too Low. You have %d attempts left%n", maxAttempts - counter);
                } else if (playerNumber > computerRandom && playerNumber <= 100) {
                    System.out.printf("Too High. You have %d attempts left%n", maxAttempts - counter);
                } else {
                    System.out.printf("Invalid input.You have %d attempts left%n", maxAttempts - counter);
                }
            } else {
                System.out.printf("Invalid input.You have %d attempts left%n", maxAttempts - counter);
            }

        }

    }
}

