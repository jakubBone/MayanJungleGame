public class Jungle extends Area{

    @Override
    void placeDescribingScene() {
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University of Mexico City. " +
                "The first thing you feel is heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! - you think ");
        System.out.println("- Ok, calm down buddy - you think to yourself. Everything will be fine");
        System.out.println("You get up and go straight, but you don't know where...");
    }
    public void firstBagCheckingScene() {
        System.out.println("You realised that you have your bag. - Oh thank God! Let's check the content. I hope" +
                "there will be something useful...");
        Item.itemList();
        System.out.println();
        System.out.println("- Ok, knife, lighter and... tequila! Yeah, together forever..." +
                "Unfortunately there is no any map... ");
        System.out.println();
    }

    public void getFirstUserChoise(){
        System.out.println("What you want to do?");
        System.out.println("0 - Choose direction");
        System.out.println("1 - Open the bag");
            // drink, prepare the item etc.
        System.out.println("2 - Get a Hint");
            // get first hint (Find some things that may be useful in defense of life, remebmer your are in jungle )
        System.out.println("4 - Quit the game"); // => game over = true
    }

    public void getSecondUserChoise(){
        System.out.println("What you want to do?");
        System.out.println("0 - Go back");
        System.out.println("1 - Open the bag");
            // drink, prepare the item etc.
        System.out.println("2 - Get a Hint");
        // get second hint (go back, choose a direction and find a useful sign in jungle)
        // if sign will be find, user will go east to get the map from the indians
        System.out.println("4 - Quit the game"); // => game over = true
    }


    @Override
    void goNorth() {
        System.out.println("Cenote");
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
        String hint = "You need a map. Ask the Indian Chief for it. Use the dictionary. "
        // use the dictionary
        // oper the bag - use the knife
        // Indian chief only want the lighter, you get the map
        // Go to the West
    }

    @Override
    void goWest() {
        System.out.println("In front of you appears the Cenote - the natural reservoir with clean water");
        String hint = "Fill the bottle and drink"
                // if no , health - 30

    void goWestAgain(){
            System.out.println("Oh shit! The jaguar! I don't want to die!");
            String hint = "Use the weapon!"
            // use knife -> jaguar bit you - 80 health
            // still fight with toxic -> jaguar die
            // disinfect the bite after a fight + 30
            // preapre the jaguar meat and eat -> the health + 50

    }




}
