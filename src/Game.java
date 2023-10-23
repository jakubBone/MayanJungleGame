
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);

    static String answer = "";
    Item item = new Item();

    void gamePlay() {
        startGame();
        History.welcomeText();
        History.firstBagCheck();
        item.itemList();
        while (true) {
            // all game
            break;
        }
        quitGame();
    }
    void startGame() {
        String name;
        while(true) {
            try {
                System.out.print("Welcome in game. Please, enter your name: ");
                name = scanner.nextLine();
                System.out.println();
                if (!name.matches("^[a-zA-Z]+$"))
                    throw new IllegalArgumentException("The name can't contain numbers or special signs");
            System.out.println("Hello " + name);
            break;
            } catch(IllegalArgumentException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    void quitGame(){
        System.out.println("Thank you for the game. See you again!");
    }



}
