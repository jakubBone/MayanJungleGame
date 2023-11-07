import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Item {
    String poison = "POISON";
    String woodSticks = "WOOD STICKS";
    public boolean ifBottleIsFilled = false;
    public boolean ifTequilaDrank = false;

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

    public void useItem() {
        System.out.println("Choose the item:");
        openTheBag();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (true) {
            if (input >= 0 && input <= bag.size()) {
                if (input == 0) {
                    useKnife();
                    break;
                } else if (input == 1) {
                    useTequila();
                    break;
                } else if (input == 2) {
                    useBottle();
                    break;
                } else if (input == 3) {
                    if (bag.contains("lighter")) {
                        useLighter();
                        break;
                    } else {
                        useCocoa();
                        break;
                    }
                } else if (input == 4) {
                    useDictionary();
                    break;
                } else if (input == 5 || input == 6) {
                    if (bag.contains("toxic spear")) {
                        useToxicSpear();
                        break;
                    } else {
                        preapareToxicSpear();
                        break;
                    }
                } else
                System.out.println("Invalid choice buddy. Please again");
            }
        }
    }

    void healthfightResult(){
        if(Game.playerHealth == 0 || Game.jaguarHealth == 0) {
            if (Game.playerHealth == 0) {
                System.out.println("The jaguar killed you...");
                Game.exitGame();
            }
            else {
                System.out.println("You kill the jaguar!");
                Jungle.ifSouthAgainExplored = true;
            }
        } else
            System.out.println("Keep fighting!");
    }
    void printHealthLevels(){
        System.out.println("|| Your health: " + Game.playerHealth + " ||");
        System.out.println("|| Jaguar health: " + Game.jaguarHealth + " ||");
    }
    public void useKnife(){
        if(Jungle.whereIsPlayerNow.equals("SouthAgain")) {
            System.out.println("The knife is to small to kill jaguar");
            System.out.println("You cut him, but he also bitten you!\"");
            Game.playerHealth -=25;
            Game.jaguarHealth -=10;
            printHealthLevels();
            healthfightResult();
        }
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useCocoa(){
        Game.playerHealth += 20;
        System.out.println("You eat cocoa grains. Your health increased to " + Game.playerHealth);
    }
    public void useTequila() {
        if (!ifTequilaDrank) {
            if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
                System.out.println("You are too drunk to fight with jaguar. He is killing you...");
            } else {
                System.out.println("You are drunk. Don't lost your bag and beware of dangers in the jungle!");
                ifTequilaDrank = true;
            }
        }
        else
            System.out.println("You drank the entire bottle!");
    }
    public void useBottle() {
        if (Jungle.whereIsPlayerNow.equals("South")) {
            System.out.println("You filled bottle by water. You can Drink it later to increase your health!");
            ifBottleIsFilled = true;
        } else {
            if (ifBottleIsFilled) {
                Game.playerHealth += 50;
                System.out.println("You drunk the holy water. Your health has inceased to " + Game.playerHealth);
            } else
                System.out.println("The bottle is empty. Find something to drink quickly!");
        }
    }


    public void useLighter() {
        if(Jungle.whereIsPlayerNow.equals("East") && Jungle.ifIndianTranslated) {
            Jungle.getIndianHint();
            System.out.println("The Indian also gave you the Cocoa to eat");
            bag.set(bag.indexOf("lighter"), "cocoa");
        }
        else
            System.out.println("The item not useful in this situation. Choose another the item");
    }

    public void useDictionary(){
        if(Jungle.whereIsPlayerNow.equals("East") && !Jungle.ifIndianTranslated) {
            System.out.println("- Dear Gringo, I'll show you the way, but in exchange for your lighter - Indian said");
            Jungle.ifIndianTranslated = true;
        }
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useToxicSpear(){
        if(Jungle.whereIsPlayerNow.equals("SouthAgain")){
            System.out.println("Right choice!");
            Game.jaguarHealth = 0;
            printHealthLevels();
            healthfightResult();
        }
        else {
            System.out.println("The item not useful in this situation. Choose another the item.");
        }
    }

    public void preapareToxicSpear() {
        if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
            System.out.println("It's to late for preparing the weapon. The Jaguar killed you");
            Game.exitGame();
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




