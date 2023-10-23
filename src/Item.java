import java.util.ArrayList;
import java.util.Arrays;

public class Item {

    public static ArrayList<String> bag = new ArrayList<>();

    static{
        bag.add("knife");
        bag.add("tequila");
        bag.add("bottle");
        bag.add("lighter");
        bag.add("dictionary");
    }
    public void itemList(){
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
            System.out.println("nie jest w liście."); // make Exceptions
        }
    }
}
