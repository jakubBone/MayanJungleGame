import java.util.Scanner;

public abstract class Area {
    Scanner scanner = new Scanner(System.in);

    public abstract void firstScene();

    public abstract void lastScene();

    boolean ifPlayerIsHere;

    public void getMainChoice() {
        String input;
        while (true) {
            System.out.println("What you want to do?");
            System.out.println("0 - Choose direction");
            System.out.println("1 - Get a Hint");
            System.out.println("2 - Quit the game");
            input = scanner.nextLine();
                    if (input.equals("0")) {
                        getDirection();
                        break;
                    }
                    else if (input.equals("1"))
                        getHint();
                    else if (input.equals("2"))
                        System.exit(0);
                    else
                        System.out.println("Invalid choice buddy. Please again");
            }

        }
    public abstract void getDirection();
    public void getHint(){
    }
    public String useItem(){
        Item.openTheBag();
        return scanner.nextLine();
    }

    // IN PROGRESS
    public static String chooseItem() {
        Item.openTheBag();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input >= 0 && input < Item.bag.size()) {
            String selectedItem = Item.bag.get(input);
            if (isItemUsefulNow(selectedItem)) {
                return selectedItem;
            } else {
                System.out.println("This item is not useful in the current situation.");
                return null;
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
            return chooseItem();
        }
    }
    // IN PROGRESS
    public boolean isItemUsefulNow(String item) {
        if(ifPlayerIsHere)
            return true;
    }



}
