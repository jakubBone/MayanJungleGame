import java.util.Scanner;

public class Jungle extends Area {

    static boolean ifNorthExplored = false;
    static boolean ifSouthExplored = false;
    static boolean ifEastExplored = false;
    static boolean ifWestExplored = false;
    Scanner scanner = new Scanner(System.in);
    @Override
    void placeDescribingScene() {
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
        System.out.println("|| Your healh level is " + Game.playerHealth +
                ", so you need to eat and drink || ");
    }



    public void getDirection() {
        String direction;
        while(true) {
            System.out.println("N - Go north");
            System.out.println("S - Go south");
            System.out.println("E - Go east");
            System.out.println("W - Go west");
            direction = scanner.nextLine();
            if (direction.equals("N") && !ifNorthExplored)
                goNorth();
            else if (direction.equals("S") && !ifSouthExplored)
                goSouth();
            else if (direction.equals("E") && !ifEastExplored)
                goEast();
            else if (direction.equals("W") && !ifWestExplored)
                goWest();
            else
                System.out.println("Invalid choice or you have been here before. Please try again of change direction.");
            }
        }


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
        System.out.println("- Mayan had a great astronomic knowledge. Maybe it would be useful in the future");
        System.out.println("You come back to the crossroad");
        ifNorthExplored = true;
    }


    void goSouth() {
        System.out.println("There is a flower with intense colors and iridescent petals that captures your attention");
        System.out.println("Also you see ");
        System.out.println("Go back?");
    }


    void goEast() {
        System.out.println("Find the Indian Village");
        String hint = "You need a map. Ask the Indian Chief for it. Use the dictionary";
        // use the dictionary
        // oper the bag - use the knife
        // Indian chief only want the lighter, you get the map
        // Go to the West
    }


    void goWest() {
        System.out.println("In front of you appears the Cenote - the natural reservoir with clean water");
        String hint = "Fill the bottle and drink";
        goWestAgain();
    }

    void goWestAgain() {
        System.out.println("Oh shit! The jaguar! I don't want to die!");
        String hint = "Use the weapon!";
        // use knife -> jaguar bit you - 80 health
        // still fight with toxic -> jaguar die
        // disinfect the bite after a fight + 30
        // preapre the jaguar meat and eat -> the health + 50

    }
}
