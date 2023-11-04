import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);
    String poison = "POISON";
    String woodSticks = "WOOD STICKS";
    public boolean ifBootleIsFilled = false;
    public String whereIsPlayerNow = "Crossroad";
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
        return additionalItem1 + additionalItem2;
    }

    // In progress
    public void useItem() {
        System.out.println("Choose the item:");
        openTheBag();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(true){
        if(input >= 0 && input <= bag.size()) {
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
        if(whereIsPlayerNow.equals("SecondSouth")) {
            System.out.println("The knife is to small to kill jaguar. Change the weapon!");
            System.out.println("The end");
            System.exit(0);
        } else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }
    public void useTequila(){
        if(whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("You are too drunk to fight with jaguar. He is killing you...");
        else
            System.out.println("You are drunk. Don't lost your bag!");
    }
    public void useBottle(){
        if(whereIsPlayerNow.equals("FirstSouth")) {
            Game.playerHealth = 100;
            ifBootleIsFilled = true;
            System.out.println("You filled bottle by water. You drunk it and your health increase to " + Game.playerHealth);
        } else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }


    public void useLighter(){
        if(whereIsPlayerNow.equals("East")) {
            System.out.println("You exchanged the lighter for a hint.");
        } else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useDictionary(){
        if(whereIsPlayerNow.equals("East"))
            System.out.println("Let's try to translate the Nahuatl to English");
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public void useToxicSpear(){
        if(whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("You kill the jaguar using the toxic spear");
        else {
            System.out.println("The item not useful in this situation. Choose another the item.");
        }
    }

    public void preapareToxicSpear() {
        if (whereIsPlayerNow.equals("SecondSouth")) {
            System.out.println("It's to late for preparing the weapon. The Jaguar is killing you");
            System.out.println("The End");
            System.exit(0);
        } else {
            System.out.println("Let's use the poison and wood sticks to prepare a weapon");
            addItem("toxic spear");
            removeItem("poison");
            removeItem("wood sticks");
            System.out.println("You have prepared a dangerous toxic.");
        }
    }

    public void addItem(String item) {
        bag.add(item);
    }

    public void removeItem(String item) {
        bag.remove(item);
    }

}




