import java.util.Scanner;

public class Jungle extends Area {

    boolean ifNorthExplored = false;
    boolean ifSouthExplored = false;
    boolean firstSouthExplored = false;
    boolean secondSouthExplored = false;
    boolean ifEastExplored = false;
    boolean ifWestExplored = false;

    Scanner scanner = new Scanner(System.in);



    @Override
    public void firstScene() {
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University of Mexico City. " +
                "The first thing you feel is heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! - you think ");
        System.out.println("- Ok, calm down buddy - you think - Everything will be fine...");
        System.out.println("You get up and go straight, but you don't know where...");
    }

    public void firstBagCheckingScene() {
        System.out.println("You realised that you have your bag. - Oh thank God! Let's check the content. I hope" +
                "there will be something useful...");
        Item.itemList();
        System.out.println();
        System.out.println("- Ok, knife, lighter and... tequila! Yeah, together forever..." +
                "Unfortunately there is no any map... ");
        System.out.println("suddenly you find the path! As if someone had been here before... " +
                "You keep following it until you find a crossroads with 4 paths -" +
                " north, south, east and west paths");
        System.out.println();
        System.out.println("-Let's try to quit this place!");
        System.out.println();
        System.out.println("|| Your healh level is " + Game.playerHealth + " ||");
        System.out.println("Find something to eat and drink to get stronger");
    }

    @Override
    public void lastScene() {
        System.out.println("You go straight. suddenly there is light in your path");
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
            } else if (direction.equals("S") && !ifSouthExplored && (!firstSouthExplored || !secondSouthExplored)) {
                if (!firstSouthExplored) {
                    goSouth();
                    firstSouthExplored = true;
                } else {
                    goSouthAgain();
                    secondSouthExplored = true;
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
        System.out.println("You come back to the crossroad");
        ifNorthExplored = true;
    }

    void goSouth() {
        System.out.println("On your way you find a flower with intense colors and iridescent petals that captures your attention");
        Item.putItems("poison", "wood sticks");
        System.out.println("Now you can prepare a spear to defend yourself against animals");
        System.out.println("Would you like to prepare the weapon?");
        System.out.println("Yes - 0");
        System.out.println("No - 1");
        String input = scanner.nextLine();
        if (input.equals("0"))
            Item.prepareToxicSpear();
    }

    void goSouthAgain() {
        System.out.println("Oh shit! The jaguar! You have to fight with him!");

        fightWithJaguar();
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

    // DONE
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

    //DONE
    @Override
    public void getHint() {
        if (!ifEastExplored)
            System.out.println("Your hint: Go East and find Indian Village!");
        else {
            getIndianHint();
        }
    }

    //DONE
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

    void getIndianHint() {
        System.out.println("- Dear White Man, these are my hints:");
        System.out.println("First: Go North to find a sign");
        System.out.println("Next: Go West to heal you");
        System.out.println("At the end: Go South and continue straight");
    }
}