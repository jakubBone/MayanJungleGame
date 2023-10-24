public class History {
    Item item = new Item();
    Jungle jungle = new Jungle();
    MayanCity mayanCity = new MayanCity();
    public void wakeUpScene(){
        System.out.println("You wake up suddenly in an unknown place. The last thing you remember is " +
                "a meeting with professor Luis Enrique from Anthropology University of Mexico City. " +
                "The first thing you feel is heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! - you think ");
        System.out.println("- Ok, calm down buddy - you think to yourself. Everything will be fine");
        System.out.println("You get up and go straight, but you don't know where...");
    }
    public void firstBagCheckingScene(){
        System.out.println("You realised that you have your bag. - Oh thank God! Let's check the content. I hope" +
                "there will be something useful...");
        item.itemList();
        System.out.println();
        System.out.println("- Ok, knife, lighter and... tequila! Yeah, together forever..." +
                "Unfortunately there is no any map... ");
        System.out.println();

    public void getFirstUserChoise(){
            System.out.println("What you want to do?");
            System.out.println("0 - Go straight");
            System.out.println("1 - Open the bag");
            System.out.println("2 - Get a Hint");
            System.out.println("3 - Prepare an item");
            System.out.println("4 - Quit the game"); // => game over = true
        }

    }
    public void drinkingScene(){
        System.out.println();
        System.out.println("In front of you appears the Cenote - the natural reservoir with clean water");

    }
    public void cookingScener(){

    }

    public void jaguarScene(){
        System.out.println("Oh shit! The jaguar! I don't want to die!");
    }

    public static void huntScene(){
        System.out.println("");
    }



}
