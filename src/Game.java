import java.util.ArrayList;

public class Game {
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

    public void addItem(String item){
        bag.add(item);
    }
}
