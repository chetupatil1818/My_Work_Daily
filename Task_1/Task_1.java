import java.util.Random;
import java.util.Scanner;
//Number_Game
public class Task_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        int totalRounds = 0;
        String playAgain;

        do {
            int numberToGuess = random.nextInt(100) + 1; 
            int attempts = 5;
            boolean hasWon = false;
            
            System.out.println("A random number between 1 and 100 has been generated.");
            System.out.println("You have " + attempts + " attempts to guess the correct number.");
            
            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasWon = true;
                    roundsWon++;
                    break;
                } 
                else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } 
                    else {
                     System.out.println("Too low! Try again.");
                    }
                attempts--;
                System.out.println("You have " + attempts + " attempts left.");
            }
            
            if (!hasWon) {
                System.out.println("You've run out of attempts. The correct number was " + numberToGuess);
            }
            
            totalRounds++;
            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = sc.next();
            
        } 
        while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("You won " + roundsWon + " out of " + totalRounds + " rounds.");
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
