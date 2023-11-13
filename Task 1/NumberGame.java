import java.util.Random;
import java.util.Scanner;

public class NumberGame{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int minRange=1;
        int maxRange=100;
        int maxAttempts=10;
        int totalRounds=0;
        int score=0;
 
        System.out.println("\n*******WELCOME TO THE NUMBER GUESSING GAME*******");
        boolean playAgain=true;
        while(playAgain){
            int generatedNumber=random.nextInt(maxRange-minRange + 1) + minRange;
            int attempts=0;
            boolean guessedCorrectly=false;

            System.out.println("\nRound:"+(totalRounds+1));
            System.out.println("\nSystem has generated a number between" + minRange + "and" + maxRange + ".");
            System.out.println("You have" + maxAttempts + "attempts to guess the number.Good luck!");
            totalRounds++;
            while(attempts < maxAttempts && !guessedCorrectly){
                System.out.println("\nAttempt:" + (attempts+1) + "/" + maxAttempts);
                System.out.print("Enter your guess =>");
                int userGuess = scanner.nextInt();
                scanner.nextLine();

                if(userGuess < generatedNumber){
                    System.out.println("\nIt's too low!");
                }

                else if(userGuess > generatedNumber){
                    System.out.println("\nIt's too high!");
                }

                else{
                    System.out.println("Congrats!!You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                }

                attempts++;
            }

            if(!guessedCorrectly){

                System.out.println("\nSorry! You have no attempts left.");
                System.out.println("The correct number was:" + generatedNumber);
            }

            System.out.print("\nWould you like to play this game again?(Yes/No)=>");
            String playAgainResponse = scanner.nextLine();

            if(!playAgainResponse.equalsIgnoreCase("yes")){
                playAgain = false;
            }
        }

        System.out.println("\nGame over! Your score is:" + score);
        System.out.println("Thanks for playing!");
    }
}