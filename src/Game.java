
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static String playerName;
    static int playerHealth = 50;

    Item item = new Item();

    Jungle jungle = new Jungle();

    void gamePlay() {
        Jungle jungle = new Jungle();
        System.out.print("Welcome in game. Please, enter your name: ");
        playerName = scanner.nextLine();
        System.out.println();
        System.out.println("Hello " + playerName + "Let's begin the game!");
        jungle.firstScene();
        jungle.firstBagCheckingScene();
        while(true) {
            getMainChoice();
        }
    }

    public void getMainChoice() {
        String input;
        while (true) {
            System.out.println("What you want to do?");
            System.out.println("0 - Choose direction");
            System.out.println("1 - Open the bag");
            System.out.println("2 - Get a Hint");
            System.out.println("3 - Quit the game");
            input = scanner.nextLine();
            if (input.equals("0")) {
                jungle.getDirection();
                break;
            }
            else if (input.equals("1")) {
                item.useItem();
            }
            else if (input.equals("2"))
                jungle.getHint();
            else if (input.equals("3"))
                System.exit(0);
            else
                System.out.println("Invalid choice buddy. Please again");
        }

    }



    }

