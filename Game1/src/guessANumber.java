import java.util.Random;
import java.util.Scanner;

public class guessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomNumber = new Random();
        int computerRandom = randomNumber.nextInt(100);
        int playerNumber = 0;

        while (computerRandom != playerNumber) {
            System.out.print("Guess s number (1-100): ");
            String playerInput = scanner.nextLine();
            boolean isValid = true;
            for (int i = 0; i < playerInput.length(); i++) {
                if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                    isValid = false;
                }
            }
            if (isValid) {
                playerNumber = Integer.parseInt(playerInput);
                if (playerNumber == computerRandom) {
                    System.out.println("You guess it!");
                    break;
                } else if (playerNumber < computerRandom  && playerNumber>0) {
                    System.out.println("Too Low");
                } else if(playerNumber > computerRandom && playerNumber<=100 ){
                    System.out.println("Too High");
                }else{
                    System.out.println("Invalid input.");
                }
            } else {
                System.out.println("Invalid Input.");
            }

        }
    }
}

