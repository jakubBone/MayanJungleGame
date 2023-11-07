import java.util.Scanner;

public class Jungle {
    public boolean ifNorthExplored = false;
    public boolean ifSouthExplored = false;
    public boolean ifSouthAgainExplored = false;
    public boolean ifEastExplored = false;
    public boolean ifWestExplored = false;
    public static boolean ifIndianTranslated = false;
    public static String whereIsPlayerNow = "Crossroad";

    Scanner scanner = new Scanner(System.in);
    Item item = new Item();
    Game game = new Game();

    public void getDirection() {
        String direction;
        while (true) {
            System.out.println("N - Go north");
            if(!ifSouthExplored)
                System.out.println("S - Go south");
            else
                System.out.println("S - Go south again");
            System.out.println("E - Go east");
            System.out.println("W - Go west");

            direction = scanner.nextLine().toUpperCase();

            if (direction.equals("N") && !ifNorthExplored) {
                goNorth();
                break;
            } else if (direction.equals("S") && (!ifSouthExplored || !ifSouthAgainExplored)) {
                if (!ifSouthExplored) {
                    goSouth();
                    ifSouthExplored = true;
                } else {
                    goSouthAgain();
                    ifSouthAgainExplored = true;
                }
                break;
            } else if (direction.equals("E") && !ifEastExplored) {
                goEast();
                break;
            } else if (direction.equals("W") && !ifWestExplored) {
                goWest();
                break;
            } else
                Game.slowPrint("Invalid choice or you have been here before. Please try again or change direction.", Game.TEXT_DELAY);
        }
    }
    void goCrossroad(){
        Game.slowPrint("You turned back to the Crossroad", Game.TEXT_DELAY);
        Jungle.whereIsPlayerNow = "Crossroad";

    }
    void goNorth() {
        whereIsPlayerNow = "North";
        Game.slowPrint("On your way you find a flower with intense colors and wood sticks", Game.TEXT_DELAY);
        Game.slowPrint("They would be useful. Do you want to take them?", Game.TEXT_DELAY);
        System.out.println("0 - Yes");
        System.out.println("1 - No");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                item.putItems("poison", "wood sticks");
                System.out.println();
                Game.slowPrint("Now you can use them to prepare a new weapon - toxic spear \n ", Game.TEXT_DELAY);
                ifNorthExplored = true;
                break;
            } else if (input.equals("1")) {
                Game.slowPrint("Remember, you are in Jungle. All items would be useful...", Game.TEXT_DELAY);
                break;
            }
            else
                Game.slowPrint("Invalid choice. Please try again.", Game.TEXT_DELAY);
        }
    }

    void goSouth() {
        whereIsPlayerNow = "South";
        Game.slowPrint("In front of you appears the lake with Indian Holly Water ", Game.TEXT_DELAY);
        Game.slowPrint("You should fill the bottle with Holly Water", Game.TEXT_DELAY);
        ifSouthExplored = true;
    }

    void goSouthAgain() {
        whereIsPlayerNow = "SouthAgain";
        Game.slowPrint("You passed the lake with Holly Water and continued on. And suddenly... \n", Game.TEXT_DELAY);
        Game.slowPrint("Oh shit! It's jaguar! You have to fight with him! \n", Game.TEXT_DELAY);
            fightWithJaguar();
    }

    void fightWithJaguar() {
            if (Game.playerHealth == 50) {
                Game.slowPrint("You health level is too little...\n", Game.TEXT_DELAY);
                Game.slowPrint("You didn't drunk the Holy Water from lake. It could cure you! So...", Game.TEXT_DELAY);
                Game.slowPrint("...the jaguar killed you...\n", Game.TEXT_DELAY);
                System.exit(0);
            } else {
                while (Game.jaguarHealth > 0) {
                    Game.slowPrint("Use the weapon!", Game.TEXT_DELAY);
                    item.useItem();
                }
            }
        ifSouthAgainExplored = true;
    }

    void goEast() {
        whereIsPlayerNow = "East";
        Game.slowPrint("You found the Indian Village", Game.TEXT_DELAY);
        Game.slowPrint("Would you like to ask the Indian Chief for a appropriate way?", Game.TEXT_DELAY);
        System.out.println("0 - Yes");
        System.out.println("1 - No");
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("0")) {
                while (Item.bag.contains("lighter")) {
                    if (!ifIndianTranslated) {
                        Game.slowPrint("The Indian talk to you in Mayan language", Game.TEXT_DELAY);
                        Game.slowPrint("Open the bag and use the dictionary \n", Game.TEXT_DELAY);
                        item.useItem();
                    } else {
                        Game.slowPrint("Exchange the lighter to a hint \n", Game.TEXT_DELAY);
                        item.useItem();
                    }
                }
                ifEastExplored = true;
                break;
            }

            else if (input.equals("1")) {
                Game.slowPrint("No? You need to get the hints from Indian. It would be good to ask him for way.\n", Game.TEXT_DELAY);
                break;
            } else
                Game.slowPrint("Invalid choice. Please try again.", Game.TEXT_DELAY);
        }
    }

    void goWest() {
        whereIsPlayerNow = "West";
        Game.slowPrint("You find a huge tree with a strange sign on it.", Game.TEXT_DELAY);
        System.out.println();
        System.out.println(" #######");
        System.out.println("#      ###########");
        System.out.println("        #       #");
        System.out.println("         #######");
        System.out.println();
        Game.slowPrint("- This is the Big Dipper constellation! - you think", Game.TEXT_DELAY);
        Game.slowPrint("- The Mayan had great astronomic knowledge. Maybe it would be useful in the future... \n", Game.TEXT_DELAY);
        ifWestExplored = true;
    }


    public void getHint() {
        if(whereIsPlayerNow.equals("SecondSouth"))
            Game.slowPrint("Use knife or toxic spear to kill the jaguar!", Game.TEXT_DELAY);
        else {
            if (!ifEastExplored)
                Game.slowPrint("Your hint: Go East and find Indian Village!", Game.TEXT_DELAY);
            else {
                getIndianHint();
            }
        }
    }

    public static void getIndianHint() {
        Game.slowPrint("*****************************************", Game.TEXT_DELAY);
        Game.slowPrint("- Dear White Man, these are the hints: ", Game.TEXT_DELAY);
        System.out.println("1st hint: Go North to find a sign");
        System.out.println("2nd hint: Go West to heal you");
        System.out.println("3rd hint: Go South and continue straight ");
        Game.slowPrint("***************************************** \n", Game.TEXT_DELAY);
    }
}

