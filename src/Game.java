
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static int playerHealth = 50;
    static int jaguarHealth = 100;

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
        System.out.println("Hello " + playerName + " Let's begin the game!");
        firstScene();
        getMainChoice();
        lastScene();
        exitGame();
    }

    public void firstScene() {
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University\nof Mexico City. " +
                "There are a lot of tropical trees and birdsong like you've never heard before... ");
        System.out.println("Where the hell I am ?! - you think");
        System.out.println("You get up and go straight, and you realised that probably you're somewhere in the mexican jungle... \n ");
        System.out.println("You have your bag. Let's check the content:");
        System.out.println(Item.bag);
        System.out.println();
        System.out.println("You are going through the jungle. Suddenly, you find a Crossroads with 4 directions -" +
                " North, South, East and West \n");
        System.out.println("|| Your health leveL: " + Game.playerHealth + " ||");
        System.out.println("Find something to get you stronger!\n");

    }
    public void lastScene() {
        System.out.println("It becomes dark and night falls...");
        System.out.println("You look at the stars. There is the Great Dipper constellation in the South \n");
        System.out.println("- The same sign that you found in a tree! - you scream \n");
        System.out.println("You're walking in that direction and suddenly...");
        System.out.println("...the jungle ends! You survived! You are saved!");

    }

    public void getMainChoice() {
        while (!jungle.ifSouthAgainExplored) {
            System.out.println("-----------------------");
            System.out.println("What do you want to do?");

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
                        System.out.println("You can't escape. Fight the jaguar!");
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
                    System.out.println("Invalid choice buddy. Please try again.");
            }
        }
    }


    public static void exitGame(){
        System.out.println("The End");
        System.exit(0);
    }

}

