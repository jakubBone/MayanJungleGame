import java.util.Scanner;

public abstract class Area {
    Scanner scanner;
    void abstract placeDescribingScene(){
    }
    public void getMainChoice() {
        int input;
        while(true) {
            System.out.println("What you want to do?");
            System.out.println("0 - Choose direction");
            System.out.println("1 - Open the bag");
            // drink, prepare the item etc.
            System.out.println("2 - Get a Hint");
            // get first hint (Find some things that may be useful in defense of life, remebmer your are in jungle )
            System.out.println("3 - Quit the game");
            input = scanner.nextInt();

            if(input >= 0 && input <=4) {
                if (input == 0) {
                    getDirection();
                    break;
                }else if (input == 1) {
                    Item.openTheBag();
                    //System.out.println("You don't need to use the items right now");
                }else if(input == 2) {
                    System.out.println("You need to choose direction");
                }else if (input == 3){
                    //System.out.println("Thank you for the game. See you again!");
                    //System.exit(3);
            }
            else
                System.out.println("Invalid choice buddy. Please again");

                }
            } else
                System.out.println("Invalid choice buddy. Please again");
        }
    }

    public void getDirection() {
    }


}
