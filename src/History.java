public class History {
    Item item = new Item();
    public void welcomeText(){
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University of Mexico City. " +
                "The first thing you feel is heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! - you think ");
        System.out.println("- Ok, calm down buddy - you think to yourself. Everything will be fine");
        System.out.println("You get up and go straight, but you don't know where...");
    }
    public void firstBagCheck(){
        System.out.println("You realised that you have your bag. Would you like to check the bag content?");
        item.itemList();
    }
    public void drink(){
        System.out.println("In front of you appears the Cenote - the natural reservoir with clean water");

    }
    public void preapereTheMeat(){

    }

    public void fight(){
        System.out.println("Oh shit! The jaguar! I don't want to die!");
    }

    public static void hunt(){
        System.out.println("");
    }



}
