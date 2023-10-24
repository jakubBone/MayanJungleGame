import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Item {
    Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> bag = new ArrayList<>();
    static{
        bag.add("knife");
        bag.add("tequila");
        bag.add("bottle");
        bag.add("lighter");
        bag.add("dictionary");
    }

    void openTheBag(){
        itemList();
    }

    public static void itemList(){
        System.out.println("Choose item: ");
        int i = 0;
        for(String element: bag){
            System.out.println(i + " - " + element);
            i++;
        }
        System.out.println();
    }

    public void addItem(String ... item){
        bag.add(Arrays.toString(item));
        System.out.println("the " + item + " hidden into the bag");
    }

    public void prepareToxicArrow(){
        if (bag.contains("poison") && bag.contains("wood sticks")) {
            String arrow = "toxic arrow";
            addItem(arrow);
            System.out.println();
        } else {
            System.out.println("You need both posion and wood sticks prepare toxic arrows ");
        }
    }
}
