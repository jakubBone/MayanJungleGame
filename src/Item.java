import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);
    String additionalItem1 = "POISON";
    String additionalItem2 = "WOOD STICKS";
    public static List<String> bag = new ArrayList<>(Arrays.asList("knife", "tequila", "bottle", "lighter", "dictionary"));

    public static void openTheBag(){
        System.out.println("Your items: ");
        itemList();
    }
    public static void addItem(String item) {
        bag.add(item);
    }

    public static void removeItem(String item) {
        bag.remove(item);
    }
    public static void itemList(){
       for(int i = 0; i < Item.bag.size(); i++) {
            System.out.println(i + " - " + Item.bag.get(i));
        }
    }

    public static void prepareToxicSpear(){
            if (bag.contains("poison") && bag.contains("wood sticks")) {
                addItem("toxic spear");
                removeItem("poison");
                removeItem("wood sticks");
                System.out.println("You have prepared a toxic spear.");
            } else {
                System.out.println("You need both poison and wood sticks to prepare a toxic spear.");
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
}



