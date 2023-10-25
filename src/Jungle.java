import java.util.Scanner;

public class Jungle extends Area {

    static boolean ifNorthNotExplored = true;
    static boolean ifSouthNotExplored = true;
    static boolean ifEastNotExplored = true;
    static boolean ifWestNotExplored = true;
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

    public void getCrossroadChoice() {
        int choice;
        while(true) {
        System.out.println("What you want to do?");
        System.out.println("0 - Choose direction");
        System.out.println("1 - Open the bag");
        // drink, prepare the item etc.
        System.out.println("2 - Get a Hint");
        // get first hint (Find some things that may be useful in defense of life, remebmer your are in jungle )
        System.out.println("3 - Quit the game"); // => game over = true
        choice = scanner.nextInt();
            if(choice >= 0 && choice <=4){
                switch(choice){
                    case 0:
                        getDirectionChoice();
                        break;
                    case 1:
                        Item.openTheBag();
                        System.out.println("You don't need to use the items right now");
                    case 2:
                        System.out.println("You need to choose direction");
                    case 3:
                        Game.quitGame();
                        break;
                }
                break;
            } else
                System.out.println("Invalid choice buddy. Please again");
        }
    }

    public void getDirectionChoice() {
        String direction;
        while(true) {
            System.out.println("N - Go north");
            System.out.println("S - Go south");
            System.out.println("E - Go east");
            System.out.println("W - Go west");
            scanner.nextLine();
            direction = scanner.nextLine().toUpperCase();
            if("NSEW".contains(direction)){
                switch(direction){
                    case "N":
                        if(ifNorthNotExplored) {
                            goNorth();
                            ifNorthNotExplored = false;
                            break;
                        } else
                            System.out.println("You have been there. Change direction");
                    case "S":
                        if(ifSouthNotExplored) {
                            goSouth();
                            ifSouthNotExplored = false;
                            break;
                        } else
                            System.out.println("You have been there. Change direction");
                    case "E":
                        if(ifEastNotExplored) {
                            goEast();
                            ifEastNotExplored = false;
                            break;
                        } else
                            System.out.println("You have been there. Change direction");
                    case "W":
                        if(ifWestNotExplored) {
                            goWest();
                            ifWestNotExplored = false;
                            break;
                        } else
                            System.out.println("You have been there. Change direction");
                        goWest();
                        break;
                }
                break;
            } else{
                System.out.println("Invalid choise buddy. Please again");
            }
        }
    }

    @Override
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
    }

    @Override
    void goSouth() {
        System.out.println("There is a flower with intense colors and iridescent petals that captures your attention");
        System.out.println("Also you see ");
        System.out.println("Go back?");
    }

    @Override
    void goEast() {
        System.out.println("Find the Indian Village");
        String hint = "You need a map. Ask the Indian Chief for it. Use the dictionary";
        // use the dictionary
        // oper the bag - use the knife
        // Indian chief only want the lighter, you get the map
        // Go to the West
    }

    @Override
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
