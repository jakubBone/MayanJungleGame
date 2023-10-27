import java.util.Scanner;

public abstract class Area {
    Scanner scanner = new Scanner(System.in);
    public abstract void placeDescribingScene();
    public void getMainChoice() {
        int input;
        while (true) {
            System.out.println("What you want to do?");
            System.out.println("0 - Choose direction");
            System.out.println("1 - Open the bag");
            // drink, prepare the item etc.
            System.out.println("2 - Get a Hint");
            System.out.println("3 - Quit the game");
            input = scanner.nextInt();

            if (input >= 0 && input <= 4) {
                if (input == 0) {
                    getDirection();
                    break;
                }else if (input == 1)
                    Item.openTheBag();
                else if (input == 2)
                    getHint();
                else if (input == 3)
                    System.exit(0);
            }else
                System.out.println("Invalid choice buddy. Please again");
            }
        }

    public abstract void getDirection();

    public abstract void getHint();

}
