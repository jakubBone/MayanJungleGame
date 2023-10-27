import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);
    String poison = "poison";
    String additionalItem = "wood sticks";
    public static ArrayList<String> bag = new ArrayList<>();
    static{
        bag.add("knife");
        bag.add("tequila");
        bag.add("bottle");
        bag.add("lighter");
        bag.add("dictionary");
    }


    public static void openTheBag(){
        System.out.println("Choose item: ");
        itemList();
    }

    public static void itemList(){

        int i = 0;
        for(String element: bag){
            System.out.println(i + " - " + element);
            i++;
        }
        System.out.println();
    }

    public static void putItem(String ... item){
        bag.add(Arrays.toString(item));
        System.out.println("the " + item + " hidden into the bag");
    }

    public static void prepareToxicSpear(){
        if (bag.contains("poison") && bag.contains("wood sticks")) {
            String spear = "toxic spear";
            putItem(spear);
            System.out.println();
        } else {
            System.out.println("You need both posion and wood sticks prepare toxic spear ");
        }
    }

}
