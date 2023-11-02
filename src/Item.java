import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);
    String additionalItem1 = "POISON";
    String additionalItem2 = "WOOD STICKS";

    public static String whereIsPlayerNow = "Crossroad";
    public static List<String> bag = new ArrayList<>(Arrays.asList
            ("knife", "tequila", "bottle", "lighter", "dictionary"));

    public static void openTheBag() {
        System.out.println("Your items: ");
        itemList();
    }

    public static void itemList() {
        for (int i = 0; i < Item.bag.size(); i++) {
            System.out.println(i + " - " + Item.bag.get(i));
        }
    }

    public static void putItems(String... items) {
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
    public static void useItem() {
        System.out.println("Choose the item:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("0"))
            useKnife();
        else if (input.equals("1"))
            useTequila();
        else if (input.equals("2"))
            useBottle();
        else if (input.equals("3"))
            useLighter();
        else if (input.equals("4"))
            useDictionary();
        else
            preapareToxicSpear();
    }

    }

    public static void useKnife(){
        if(whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("The knife is to small to kill jaguar. Change the weapon!");
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }
    public  static void useTequila(){
        if(whereIsPlayerNow.equals("SecondSouth"))
            System.out.println("You are too drunk to fight with jaguar. He is killing you...");
        else
            System.out.println("You are drunk. Don't lost your bag!");
    }
    public static void  useBottle(){
        if(whereIsPlayerNow.equals("FirstSouth")) {
            Game.playerHealth = 100;
            System.out.println("You filled bottle by water. You drunk it and your health increase to " + Game.playerHealth);
        } else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }

    public static void  useLighter(){
        if(whereIsPlayerNow.equals("East")) {
            System.out.println("You exchanged the lighter for a hint.");
        } else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }
    public static void useDictionary(){
        if(whereIsPlayerNow.equals("East"))
            System.out.println("Let's try to translate the Nahuatl to English");
        else
            System.out.println("The item not useful in this situation. Choose another the item.");
    }
    public static void preapareToxicSpear(){
            System.out.println("Let's use the poison and wood sticks to prepare a weapon");
            addItem("toxic spear");
            removeItem("poison");
            removeItem("wood sticks");
            System.out.println("You have prepared a dangerous toxic.");
        }
    public static void addItem(String item) {
        bag.add(item);
    }

    public static void removeItem(String item) {
        bag.remove(item);
    }

}




