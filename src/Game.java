import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
Scanner scanner = new Scanner(System.in);

    boolean gameOver;
    void gamePlay() {
        startGame();
        while (!gameOver) {
            chooseMovement();
            itemList();
            gameOver = true;
        }
    }

    void startGame() {
        String name;
        while(true) {
            try {
                System.out.println("Welcome in game. Please, enter your name");
                name = scanner.nextLine();
                if (!name.matches("^[a-zA-Z]+$"))
                    throw new IllegalArgumentException("The name can't contain numbers or special signs")
            System.out.println("Hello" + name);
            break;
            } catch(IllegalArgumentException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public static ArrayList<String> bag = new ArrayList<>();
    static{
        bag.add("knife");
        bag.add("tequila");
        bag.add("bottle");
        bag.add("lighter");
        bag.add("dictionary");
    }

    void chooseMovement(){
        int movement = 0;
        System.out.println("0 - Open bag"); // itemList()
        System.out.println("1 - Put item");
        System.out.println("2 - Prepare item");
        System.out.println("3-  End game"); // => game over = true
        System.out.println("Choose movement: ");
        scanner.nextInt();
        switch(movement){
            case 0:
                itemList();
                break;
            case 1:
                addItem();
                break;
            case 2:
                prepareToxicArrow();
                break;
            case 3:
                gameOver = true;
                break;
        }
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
