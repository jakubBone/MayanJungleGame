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
                System.out.println("Invalid choice or you have been here before. Please try again or change direction.");
        }
    }
    void goCrossroad(){
        System.out.println("You turned back to the Crossroad");
        Jungle.whereIsPlayerNow = "Crossroad";

    }
    void goNorth() {
        whereIsPlayerNow = "North";
        System.out.println("On your way you find a flower with intense colors and wood sticks");
        System.out.println("They would be useful. Do you want to take them?");
        System.out.println("0 - Yes");
        System.out.println("1 - No");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                item.putItems("poison", "wood sticks");
                System.out.println();
                System.out.println("Now you can use them to prepare a new weapon - toxic spear \n ");
                ifNorthExplored = true;
                break;
            } else if (input.equals("1")) {
                System.out.println("Remember, you are in Jungle. All items would be useful...");
                break;
            }
            else
                System.out.println("Invalid choice. Please try again.");
        }
    }

    void goSouth() {
        whereIsPlayerNow = "South";
        System.out.println("In front of you appears the lake with Indian Holly Water ");
        System.out.println("You should fill the bottle with Holly Water");
        ifSouthExplored = true;
    }

    void goSouthAgain() {
        whereIsPlayerNow = "SouthAgain";
        System.out.println("You passed the lake with Holly Water and continued on. And suddenly... \n");
        System.out.println("Oh shit! It's jaguar! You have to fight with him! \n");
            fightWithJaguar();
    }

    void fightWithJaguar() {
            if (Game.playerHealth == 50) {
                System.out.println("You health level is too little...\n");
                System.out.println("You didn't drunk the Holy Water from lake. It could cure you! So...");
                System.out.println("...the jaguar killed you...\n");
                System.exit(0);
            } else {
                while (Game.jaguarHealth > 0) {
                    System.out.println("Use the weapon!");
                    item.useItem();
                }
            }
        ifSouthAgainExplored = true;
    }

    void goEast() {
        whereIsPlayerNow = "East";
        System.out.println("You found the Indian Village");
        System.out.println("Would you like to ask the Indian Chief for a appropriate way?");
        System.out.println("0 - Yes");
        System.out.println("1 - No");
        while (true) {
            String input = scanner.nextLine();
            if(input.equals("0")) {
                while (Item.bag.contains("lighter")) {
                    if (!ifIndianTranslated) {
                        System.out.println("The Indian talk to you in Mayan language");
                        System.out.println("Open the bag and use the dictionary \n");
                        item.useItem();
                    } else {
                        System.out.println("Exchange the lighter to a hint \n");
                        item.useItem();
                    }
                }
                ifEastExplored = true;
                break;
            }

            else if (input.equals("1")) {
                System.out.println("No? You need to get the hints from Indian. It would be good to ask him for way.\n");
                break;
            } else
                System.out.println("Invalid choice. Please try again.");
        }
    }

    void goWest() {
        whereIsPlayerNow = "West";
        System.out.println("You find a huge tree with a strange sign on it.");
        System.out.println();
        System.out.println(" #######");
        System.out.println("#      ###########");
        System.out.println("        #       #");
        System.out.println("         #######");
        System.out.println();
        System.out.println("- This is the Big Dipper constellation! - you think");
        System.out.println("- The Mayan had great astronomic knowledge. Maybe it would be useful in the future... \n");
        ifWestExplored = true;
    }


    public void getHint() {
        if(whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("Use knife or toxic spear to kill the jaguar!");
        else {
            if (!ifEastExplored)
                System.out.println("Your hint: Go East and find Indian Village!");
            else {
                getIndianHint();
            }
        }
    }

    public static void getIndianHint() {
        System.out.println("*****************************************");
        System.out.println("- Dear White Man, these are the hints: ");
        System.out.println("1st hint: Go North to find a sign");
        System.out.println("2nd hint: Go West to heal you");
        System.out.println("3rd hint: Go South and continue straight ");
        System.out.println("***************************************** \n");
    }
}

