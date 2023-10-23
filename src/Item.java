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



    void selectItemAction(){
        String movement;
        while(true) {
            try {
                System.out.println("Select an action");
                System.out.println("0 - Go straight");
                System.out.println("1 - Open the bag");
                System.out.println("2 - Pick up the item");
                System.out.println("3 - Prepare an item");
                System.out.println("4 - Quit the game"); // => game over = true
                movement = scanner.nextLine();
                if (!movement.matches("[0-4]"))
                    throw new IllegalArgumentException("Invalid input. Please select a valid option (0, 1, 2, or 3) ");
                break;
            } catch(IllegalArgumentException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        switch(movement){
            case "0":
                // go straight
                break;
            case "1":
                addItem();
                break;
            case "2":
                prepareToxicArrow();
                break;
            case "3":
                 // the end
            case "3":
                break; // the end
        }
    }
    public void itemList(){
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