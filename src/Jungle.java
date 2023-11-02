import java.util.Scanner;

public class Jungle extends Area {

    boolean ifNorthExplored = false;
    boolean ifSouthExplored = false;
    boolean ifFirstSouthExplored = false;
    boolean ifSecondSouthExplored = false;
    boolean ifEastExplored = false;
    boolean ifWestExplored = false;

    Scanner scanner = new Scanner(System.in);

    boolean ifPlayerIsHere;

    @Override
    public void firstScene() {
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University of Mexico City. " +
                "The first thing you feel is heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! - you think ");
        System.out.println("- Calm down buddy - you think - Everything will be fine...");
        System.out.println("You get up and go straight, and you realised that probably you're somewhere in the mexican jungle... \n ");
    }

    public void firstBagCheckingScene() {
        System.out.println("You have your bag. Let's check the content")
        System.out.println("Your bag: \n");
        Item.itemList();
        System.out.println();
        System.out.println("You are going through the jungle. Suddenly, you find a crossroads with 4 directions -" +
                " North, South, East and West");
        System.out.println();
        System.out.println("-Let's try to quit this place - you think");
        System.out.println();
        System.out.println("|| Your healh level is " + Game.playerHealth + " ||");
        System.out.println("Find something to get stronger");
    }

    @Override
    public void lastScene() {
        System.out.println("You are going straight. Suddenly there is light at the end on th path");
        System.out.println("This is the end of the jungle. You see some buildings. What is this place?");
    }

    @Override
    public void getDirection() {
        String direction;
        while (true) {
            System.out.println("N - Go north");
            System.out.println("S - Go south");
            System.out.println("E - Go east");
            System.out.println("W - Go west");

            direction = scanner.nextLine().toUpperCase();

            if (direction.equals("N") && !ifNorthExplored) {
                goNorth();
                break;
            } else if (direction.equals("S") && !ifSouthExplored && (!ifFirstSouthExplored || !ifSecondSouthExplored)) {
                if (!ifFirstSouthExplored) {
                    goSouth();
                    ifFirstSouthExplored = true;
                } else {
                    goSouthAgain();
                    ifSecondSouthExplored = true;
                }
                break;
            } else if (direction.equals("E") && !ifEastExplored) {
                goEast();
                break;
            } else if (direction.equals("W") && !ifWestExplored) {
                goWest();
                break;
            } else {
                System.out.println("Invalid choice or you have been here before. Please try again or change direction.");
            }
        }
    }


    //DONE
    void goNorth() {
        System.out.println("On your way you find a flower with intense colors and iridescent petals that captures your attention");
        System.out.println("They would be useful. Do you want to take them?");
        String input = scanner.nextLine();
        if(input.equals(input)) {
            Item.putItems("poison", "wood sticks");
            System.out.println("Now you can prepare a spear to defend yourself against animals");
            ifNorthExplored = true;
        } else {
            System.out.println("Remember, you are in Jungle. All items would be useful...");
        }
        System.out.println("You come back to the Crossroad");

    }

    // DONE
    void goSouth() {
        System.out.println("You find a huge tree with strange sign on it. " +
                "As if someone made it using knife on purpose");
        System.out.println();
        System.out.println(" #######");
        System.out.println("#      ###########");
        System.out.println("        #       #");
        System.out.println("         #######");
        System.out.println();
        System.out.println("- That is this is the Big Dipper constellation! - you think");
        System.out.println("- The Mayan had great astronomic knowledge. Maybe it would be useful in the future");
        ifFirstSouthExplored = true;
    }

    // IN PROGRESS
    void goSouthAgain() {
        System.out.println("Oh shit! The jaguar! You have to fight with him!");
        fightWithJaguar();
        lastScene();
    }

    // what if there is no spear in the bag?
    void fightWithJaguar() {
        if (Game.playerHealth == 50) {
            System.out.println("You health is ||" + Game.playerHealth + "|| It's so little");
            System.out.println("Before the fight you should have found an item for strengthen your health, so...");
            System.out.println("...sorry buddy, the jaguar is killing you...");
            System.out.println("The End");
            System.exit(0);
        } else {
            System.out.println("Use the weapon!");
            useItem();
            while (true) {
                if (useItem().equals("0")) {
                    if (Item.bag.contains("knife")) {
                        System.out.println("The knife is to small to kill jaguar! The jaguar is bites you and you die");
                        System.exit(0);
                    } else
                        System.out.println("There is no knife in the bag. Use another weapon!");
                } else if (useItem().equals("4")) {
                    System.out.println("You kill the jaguar using the toxic sprear");
                    break;
                } else
                    System.out.println("Invalid choise. Use the weapon!");
            }
        }
    }

    //DONE
    void goEast() {
        System.out.println("You found the Indian Village");
        System.out.println("Ask the Indian Chief for it the next direction. Use the dictionary");
        while (true) {
            Item.openTheBag();
            int input = scanner.nextInt();
            if (input == 4) {
                tradeWithIndianChief();
                break;
            } else
                System.out.println("Invalid choice. Please try arain");
        }
        System.out.println("You come back to the Crossroad");
        ifEastExplored = true;

    }

    //DONE
    void goWest() {
        System.out.println("In front of you appears the Cenote - the natural reservoir with clean water");
        System.out.println("Fill the bottle and drink");
        while (true) {
            if (useItem().equals("2")) {
                Game.playerHealth += 50;
                System.out.println("Bottle is fill by water. You drunk and your health increase to " + Game.playerHealth);
                break;
            } else
                System.out.println("Invalid choice buddy. Fill the bottle");
        }
        ifWestExplored = true;
    }

    void tradeWithIndianChief() {
        System.out.println("- Dear Gringo, I'll show you the way, but in exchange for your lighter");
        while (true) {
            Item.openTheBag();
            int input = scanner.nextInt();
            if (input == 3) {
                getIndianHint();
                break;
            } else {
                System.out.println("Invalid choice. He wants the lighter. Please try again");
            }
        }
    }

    //DONE
    @Override
    public void getHint() {
        if (!ifEastExplored)
            System.out.println("Your hint: Go East and find Indian Village!");
        else {
            getIndianHint();
        }
    }
    // Done
    void getIndianHint() {
        System.out.println("- Dear White Man, these are the hints: \n");
            System.out.println("1st hint: Go North to find a sign");
            System.out.println("2nd hint: Go West to heal you");
            System.out.println("3rd hint: Go South and continue straight");
        }
    }
}
