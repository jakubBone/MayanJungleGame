import java.util.Scanner;

public class Jungle extends Area {

    boolean ifNorthExplored = false;
    boolean ifSouthExplored = false;
    boolean ifEastExplored = false;
    boolean ifWestExplored = false;
    boolean ifFirstHintUsed = false;
    Scanner scanner = new Scanner(System.in);



    @Override
    public void placeDescribingScene() {
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
        Item.putItem("poison", "wood sticks");
        System.out.println("Now you can prepare a spear to defend yourself against animals");
        System.out.println("Would you like to prepare the weapon?");
        System.out.println("Yes - 0");
        System.out.println("No - 1");
        int input = scanner.nextInt();
        if(0)
            Item.prepareToxicSpear();
    }

    // DONE
    void goEast() {
        System.out.println("You found the Indian Village");

        String hint = "Ask the Indian Chief for it the next direction. Use the dictionary";
        while(true) {
            Item.openTheBag();
            int input = scanner.nextInt();
            if (input == 4) {
                tradeWithIndianChief();
                break;
            }
            else
                System.out.println("Invalid choice. Please try arain");
        }
        ifEastExplored = true;
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

    //DONE
    @Override
    public void getHint() {
        if(!ifFirstHintUsed)
            System.out.println("Your hint: Go West and find Indian Village!");
        else
            System.out.println("Follow the indian's advice. Go South");
    }
    //DONE
    void tradeWithIndianChief() {
        System.out.println("- Dear Gringo, I'll show you the way, but in exchange for your lighter");
        Item.openTheBag();
        int input = scanner.nextInt();
        while (true) {
            if (input == 3) {
                System.out.println("- Dear White Man, you have to go South.");
                System.out.println("- Remember, collect everything useful in the jungle! ");
                System.out.println("Now you know the direction");
                System.out.println("You turn back to the crossroad");
                break;
            } else {
                System.out.println("Invalid choice. Please try again");
            }
        }
    }
}
