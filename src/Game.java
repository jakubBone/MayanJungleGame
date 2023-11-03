
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static String playerName;
    static int playerHealth = 50;


    void gamePlay() {
        Jungle jungle = new Jungle();
        System.out.print("Welcome in game. Please, enter your name: ");
        playerName = scanner.nextLine();
        System.out.println();
        System.out.println("Hello " + playerName + "Let's begin the game!");

        jungle.firstScene();
        jungle.firstBagCheckingScene();

        while(true) {
            jungle.getMainChoice();
            }
        }

    }

