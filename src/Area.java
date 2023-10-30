import java.util.Scanner;

public abstract class Area {
    Scanner scanner = new Scanner(System.in);


    public abstract void placeDescribingScene();

    public abstract void lastScene();

    public void getMainChoice() {
        int input;
        while (true) {
            System.out.println("What you want to do?");
            System.out.println("0 - Choose direction");
            System.out.println("1 - Get a Hint");
            System.out.println("2 - Quit the game");
            input = scanner.nextInt();
            if (input >= 0 && input <= 4) {
                if (input == 0) {
                    getDirection();
                    break;
                } else if (input == 1)
                    getHint();
                else if (input == 2)
                    System.exit(0);
            } else
                System.out.println("Invalid choice buddy. Please again");
        }
    }

    public int useItem(){
        Item.openTheBag();
        return scanner.nextInt();
    }
    public abstract void getDirection();

    public void getHint(){
    }


}
