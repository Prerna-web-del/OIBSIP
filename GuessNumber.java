import java.util.*;
public class GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int number = rand.nextInt(100)+1;
        int guess = 0;
        int attempts = 0;
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 to 100:");
        while(guess != number){
            System.out.println("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;
            if (guess > number) {
                System.out.println("Too High!");
              }else if (guess < number) {
                System.out.println("Too Low!");
              }else {
                System.out.println("Correct! ");
                System.out.println("You guessed it in " + attempts + "attempts.");
              }
            }
            sc.close();
        }
}
