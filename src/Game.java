
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static int playerHealth = 50;
    public String whereIsPlayerNow = "Crossroad";

    Item item;
    Jungle jungle;

    public Game(Item item, Jungle jungle) {
        this.item = item;
        this.jungle = jungle;
    }
    public Game(){

    }
    void gamePlay() {
        System.out.print("Welcome in game. Please, enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println();
        System.out.println("Hello " + playerName + "Let's begin the game!");
        jungle.firstScene();
        jungle.firstBagCheckingScene();
        while (true) {
            getMainChoice();
        }
    }

    public void getMainChoice() {
        String input;
        while (true) {
            System.out.println("What do you want to do?");

            if (Jungle.whereIsPlayerNow.equals("Crossroad"))
                System.out.println("0 - Choose direction");
            else
                System.out.println("0 - Turn back to Crossroad");
            System.out.println("1 - Open the bag");
            System.out.println("2 - Get a Hint");
            System.out.println("3 - Quit the game");
            input = scanner.nextLine();
            if (input.equals("0")) {
                if (Jungle.whereIsPlayerNow.equals("SecondSouth"))
                    System.out.println("You can't escape. Fight the jaguar!");
                else {
                    if (Jungle.whereIsPlayerNow.equals("Crossroad"))
                        jungle.getDirection();
                    else
                        jungle.goCrossRoad();
                }
            } else if (input.equals("1"))
                item.useItem();
            else if (input.equals("2"))
                jungle.getHint();
            else if (input.equals("3"))
                System.exit(0);
            else
                System.out.println("Invalid choice buddy. Please try again.");
        }
    }
}

