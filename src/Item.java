import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);
    String poison = "POISON";
    String woodSticks = "WOOD STICKS";
    public boolean ifBottleIsFilled = false;
    Game game = new Game;

    Jungle jungle = new Jungle();

    public static List<String> bag = new ArrayList<>(Arrays.asList
            ("knife", "tequila", "bottle", "lighter", "dictionary"));

    public void openTheBag() {
        System.out.println("Your items: ");
        for (int i = 0; i < Item.bag.size(); i++) {
            System.out.println(i + " - " + Item.bag.get(i));
        }
    }

    public void putItems(String... items) {
        bag.addAll(Arrays.asList(items));
        for (String item : items) {
            System.out.println("The item " + item + " added to the bag.");
        }
    }

    @Override
    public String toString() {
        return poison + woodSticks;
    }

    void
    // In progress
    public void useItem() {
        System.out.println("Choose the item:");
        openTheBag();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(true){
        if(input >= 0 && input <= bag.size()) {
            if (input == 0) {
                if(bag.contains("knife")) {
                    useKnife();
                    break;
                }
                else {
                    useCocoa();
                    break;
                }
            } else if (input == 1) {
                useTequila();
                break;
            } else if (input == 2) {
                useBottle();
                break;
            } else if (input == 3) {
                useLighter();
                break;
            } else if (input == 4) {
                useDictionary();
                break;
            } else {
                if (bag.contains("toxic spear")) {
                    useToxicSpear();
                    break;
                } else {
                    preapareToxicSpear();
                    break;
                }
            }
        }
        else
            System.out.println("Invalid choice buddy. Please again");
        }
    }

    public void useKnife(){
        if(game.whereIsPlayerNow.equals("SecondSouth")) {
            System.out.println("The knife is to small to kill jaguar. Change the weapon!");
            System.out.println("The end");
            System.exit(0);
        }
        else if(game.whereIsPlayerNow.equals("East")){
            System.out.println("You exchanged the knife to Indian hint. In addition, Indian gave you the Holly Cocoa");
            bag.set(bag.indexOf("knife"), "cocoa");
            jungle.getIndianHint();
        }
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useCocoa(){
        Game.playerHealth = 100;
        System.out.println("You eat cocoa grains. Your health increased to " + Game.playerHealth);
    }
    public void useTequila(){
        if(game.whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("You are too drunk to fight with jaguar. He is killing you...");
        else
            System.out.println("You are drunk. Don't lost your bag and beware of dangers in the jungle!");
    }
    public void useBottle() {
        if (game.whereIsPlayerNow.equals("FirstSouth")) {
            ifBottleIsFilled = true;
            System.out.println("You filled bottle by water. Drink it quickly to increase your health!");
            game.whereIsPlayerNow = "Crossread";
        } else {
            if (ifBottleIsFilled){
                Game.playerHealth = 100)
                System.out.println("You drunk the holy water. Your health inceased to " + Game.playerHealth);
            }
            else
                System.out.println("The bottle is empty. Find something to drink quickly!");
        }
    }

    public void useLighter(){
        if(game.whereIsPlayerNow.equals("East")) {
            System.out.println("You exchanged the lighter for a hint.");
            bag.
        } else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useDictionary(){
        if(game.whereIsPlayerNow.equals("East")) {
            System.out.println("Let's try to translate the Nahuatl to English");
            jungle.tradeWithIndianChief();
            jungle.ifIndianTranslated = true;
            jungle.ifEastExplored = true;
        }
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useToxicSpear(){
        if(game.whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("You killed the jaguar using the toxic spear");
        else {
            System.out.println("The item not useful in this situation. Choose another the item.");
        }
    }

    public void preapareToxicSpear() {
        if (game.whereIsPlayerNow.equals("SecondSouth")) {
            System.out.println("It's to late for preparing the weapon. The Jaguar killed you");
            System.out.println("The End");
            System.exit(0);
        } else {
            addItem("toxic spear");
            removeItem("poison");
            removeItem("wood sticks");
            System.out.println("You have prepared a dangerous toxic spear using the poison and wood sticks");
        }
    }

    public void addItem(String item) {
        bag.add(item);
    }

    public void removeItem(String item) {
        bag.remove(item);
    }

}




