
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static String playerName;
    static int playerHealth;

    void gamePlay() {
        System.out.print("Welcome in game. Please, enter your name: ");
        playerName = scanner.nextLine();
        System.out.println();
        System.out.println("Hello " + playerName + "Let's begin the game!");

        quitGame();

    }
    void quitGame(){
        System.out.println("Thank you for the game. See you again!");
    }



}
