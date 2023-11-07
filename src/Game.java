
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    static int playerHealth = 50;
    static int jaguarHealth = 100;
    public String whereIsPlayerNow = "Crossroad";

    Item item;
    Jungle jungle;

    public Game(Item item, Jungle jungle) {
        this.item = item;
        this.jungle = jungle;
    }
    public Game(){
    }

    public void firstScene() {
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University of Mexico City. " +
                "The first thing you feel is heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! - you think ");
        System.out.println("- Calm down buddy - you think - Everything will be fine...");
        System.out.println("You get up and go straight, and you realised that probably you're somewhere in the mexican jungle... \n ");
    }

    public void firstBagCheckingScene() {
        System.out.println("You have your bag. Let's check the content");
        item.openTheBag();
        System.out.println();
        System.out.println("You are going through the jungle. Suddenly, you find a Crossroads with 4 directions -" +
                " North, South, East and West");
        System.out.println();
        System.out.println("-Let's try to quit this place - you think");
        System.out.println();
        System.out.println("|| Your health leveL: " + Game.playerHealth + " ||");
        System.out.println("Find something to get stronger");
    }

    public void lastScene() {
        System.out.println("The night begins. You look at the stars and see that in the South there is the constellation of the great dipper");
        System.out.println("The same sign that you found in a tree. You're walking in that direction and suddenly...");
        System.out.println("...the jungle ends! You are saved!");
        exitGame();
    }
    void gamePlay() {
        System.out.print("Welcome in game. Please, enter your name: ");
        String playerName = scanner.nextLine();
        System.out.println();
        System.out.println("Hello " + playerName + "Let's begin the game!");
        firstScene();
        firstBagCheckingScene();
        while (!Jungle.ifSouthAgainExplored) {
            getMainChoice();
        }
        lastScene();
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
                    if (Jungle.whereIsPlayerNow.equals("SouthAgain"))
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
                    exitGame();
                else
                    System.out.println("Invalid choice buddy. Please try again.");
            }
        }

    public static void exitGame(){
        System.out.println("The End");
        System.exit(0);
    }
}

