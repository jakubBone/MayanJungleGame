import java.util.Scanner;

public abstract class Area {

    Scanner scanner = new Scanner(System.in);

    public abstract void firstScene();

    public abstract void lastScene();



    public void getMainChoice() {
        String input;
        while (true) {
            System.out.println("What you want to do?");
            System.out.println("0 - Choose direction");
            System.out.println("1 - Open the bag");
            System.out.println("2 - Get a Hint");
            System.out.println("3 - Quit the game");
            input = scanner.nextLine();
                    if (input.equals("0")) {
                        getDirection();
                        break;
                    }
                    else if (input.equals("1")) {
                        Item.openTheBag();
                        Item.useItem();
                    }
                    else if (input.equals("2"))
                        getHint();
                    else if (input.equals("3"))
                        System.exit(0);
                    else
                        System.out.println("Invalid choice buddy. Please again");
            }

        }
    public abstract void getDirection();
    public void getHint(){
    }

}
