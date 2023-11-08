
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static int playerHealth = 50;
    static int jaguarHealth = 100;

    public static final long TEXT_DELAY = 1000;

    Item item;
    Jungle jungle;

    public Game(Item item, Jungle jungle) {
        this.item = item;
        this.jungle = jungle;
    }
    public Game(){
    }

    void gamePlay() {
        System.out.print("Welcome in MayanJungleGame. Please, enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println();
        slowPrint("Hello " + playerName + ", let's play the game!", TEXT_DELAY);
        firstScene();
        getMainChoice();
        lastScene();
        exitGame();
    }

    public void firstScene() {
        slowPrint("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University\nof Mexico City. " +
                "There are a lot of tropical trees and birdsong like you've never heard before... ", TEXT_DELAY);
        slowPrint("Where the hell I am ?! - you think", TEXT_DELAY);
        slowPrint("You get up and go straight, and you realised that probably you're somewhere in the mexican jungle... \n ", TEXT_DELAY);
        slowPrint("You have your bag. Let's check the content:", TEXT_DELAY);
        System.out.println(Item.bag);
        System.out.println();
        slowPrint("You are going through the jungle. Suddenly, you find a Crossroads with 4 directions -" +
                " North, South, East and West \n", TEXT_DELAY);
        slowPrint("|| Your health leveL: " + Game.playerHealth + " ||", TEXT_DELAY);
        slowPrint("Find something to get you stronger!\n", TEXT_DELAY);

    }
    public void lastScene() {
        slowPrint("It becomes dark and night falls...", TEXT_DELAY);
        slowPrint("You look at the stars. There is the Great Dipper constellation in the South \n", TEXT_DELAY);
        slowPrint("- The same sign that you found in a tree! - you scream \n", TEXT_DELAY);
        slowPrint("You're walking in that direction and suddenly...", TEXT_DELAY);
        slowPrint("...the jungle ends! You survived! You are saved!", TEXT_DELAY);

    }

    public void getMainChoice() {
        while (!jungle.ifSouthAgainExplored) {
            System.out.println("-----------------------");
            slowPrint("What do you want to do?", TEXT_DELAY);

            if (Jungle.whereIsPlayerNow.equals("Crossroad")) {
                System.out.println("0 - Choose direction");
            } else {
                System.out.println("0 - Turn back to Crossroad");
            }

            System.out.println("1 - Open the bag");
            System.out.println("2 - Get a Hint");
            System.out.println("3 - Quit the game");
            System.out.println("-----------------------");

            String input = scanner.nextLine();

            switch (input) {
                case "0":
                    if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
                        slowPrint("You can't escape. Fight the jaguar!", TEXT_DELAY);
                    } else {
                        if (Jungle.whereIsPlayerNow.equals("Crossroad")) {
                            jungle.getDirection();
                        } else {
                            jungle.goCrossroad();
                        }
                    }
                    break;
                case "1":
                    item.useItem();
                    break;
                case "2":
                    jungle.getHint();
                    break;
                case "3":
                    exitGame();
                    break;
                default:
                    slowPrint("Invalid choice buddy. Please try again.", TEXT_DELAY);
            }
        }
    }

    public static void slowPrint(String text, long delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
    public static void exitGame(){
        System.out.println("The End");
        System.exit(0);
    }
}

