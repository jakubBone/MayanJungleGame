import java.util.Scanner;

public class Area {
    Item item = new Item();

    Scanner scanner = new Scanner(System.in);
    public void welcomeText(){
        System.out.println("You wake up suddenly in an unknown place. The first thing you feel is " +
                "heat and humidity. There are a lot of tropical trees and birdsong like " +
                "you've never heard before... - Where the hell I am ?! ");
    }
    void selectAction(){
        String movement;
        while(true) {
            try {
                System.out.println("Select an action");
                System.out.println("0 - Open the bag"); // itemList()
                System.out.println("1 - Put the item");
                System.out.println("2 - Prepare an item");
                System.out.println("3 - End the game"); // => game over = true
                movement = scanner.nextLine();
                if (!movement.matches("[0-3]"))
                    throw new IllegalArgumentException("Invalid input. Please select a valid option (0, 1, 2, or 3) ");
                break;
            } catch(IllegalArgumentException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        switch(movement){
            case "0":
                item.itemList();
                break;
            case "1":
                item.addItem();
                break;
            case "2":
                item.prepareToxicArrow();
                break;
            case "3":
                // gameOver = true;
                break;
        }
    }

}
