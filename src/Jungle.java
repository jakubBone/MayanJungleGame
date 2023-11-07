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
    void goCrossRoad(){
        System.out.println("You turned back to the CrossRoad");
        Jungle.whereIsPlayerNow = "Crossroad";

    }
    void goNorth() {
        whereIsPlayerNow = "North";
        System.out.println("On your way you find a flower with intense colors and iridescent petals that captures your attention");
        System.out.println("They would be useful. Do you want to take them?");
        System.out.println("0 - Yes");
        System.out.println("1 - No");
        String input = scanner.nextLine();
        if(input.equals("0")) {
            item.putItems("poison", "wood sticks");
            System.out.println("Now you can use them to prepare a new weapon - toxic spear ");
            ifNorthExplored = true;
        } else if(input.equals("1"))
            System.out.println("Remember, you are in Jungle. All items would be useful...");
    }

    void goSouth() {
        whereIsPlayerNow = "South";
        System.out.println("In front of you appears the lake with Indian Holly Water");
        System.out.println("You should fill the bottle with Holly Water");
        ifSouthExplored = true;
    }

    void goSouthAgain() {
        whereIsPlayerNow = "SouthAgain";
        System.out.println("You passed the Cenote and continued on. And suddenly...");
        System.out.println("Oh shit! It's jaguar! You have to fight with him!");
            fightWithJaguar();
    }

    void fightWithJaguar() {
            if (Game.playerHealth == 50) {
                System.out.println("You health level is too little...");
                System.out.println("You didn't drunk the Holy Water from lake. It could cure you! So...");
                System.out.println("...the jaguar killed you...");
                System.out.println("The End");
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
        String input = scanner.nextLine();
        while (true) {
            if(input.equals("0")) {
                while (Item.bag.contains("lighter")) {
                    if (!ifIndianTranslated) {
                        System.out.println("The Indian talk you in Nahualt language");
                        System.out.println("Open the bag and use the dictionary");
                        item.useItem();
                    } else {
                        System.out.println("Exchange the lighter to a hint");
                        item.useItem();
                    }
                }
                ifEastExplored = true;
                break;
            }
            else if (input.equals("1")) {
                System.out.println("No? You need to get the hints from Indian. It would be good to ask him for way.");
                break;
            } else
                System.out.println("Invalid choice. Please try again.");
        }
    }

    void goWest() {
        whereIsPlayerNow = "West";
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
        System.out.println("- Dear White Man, these are the hints: \n");
            System.out.println("1st hint: Go North to find a sign");
            System.out.println("2nd hint: Go West to heal you");
            System.out.println("3rd hint: Go South and continue straight");
    }
}

