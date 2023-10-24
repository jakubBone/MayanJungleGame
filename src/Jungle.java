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
            // get first hint (choose direction)
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
        System.out.println("The jungle is too thick. there is no way you can get through");
        System.out.println("Go back?");
    }
    @Override
    void goEast() {
        System.out.println("Find the Indian Village");
        // Lighter exchanging - map
        // Indian only want the lighter
        // Go to the West
    }

    @Override
    void goWest() {
        System.out.println("In front of you appears the Cenote - the natural reservoir with clean water");
        // drink

    void goWestAgain(){
            System.out.println("Oh shit! The jaguar! I don't want to die!");

    }




}
