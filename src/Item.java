import java.util.*;

public class Item {

    Scanner scanner = new Scanner(System.in);
    String poison = "POISON";
    String woodSticks = "WOOD STICKS";
    public boolean ifBottleIsFilled = false;
    public boolean ifTequilaDrank = false;


    public static List<String> bag = new ArrayList<>(Arrays.asList
            ("knife", "tequila", "bottle", "lighter", "dictionary"));

    public void openTheBag() {
        for (int i = 0; i < Item.bag.size(); i++) {
            System.out.println(i + " - " + Item.bag.get(i));
        }
    }

    public void putItems(String... items) {
        bag.addAll(Arrays.asList(items));
        for (String item : items) {
            System.out.println("You put" + item + " to your bag");
        }

    }

    @Override
    public String toString() {
        return poison + woodSticks;
    }

    public void useItem() {
        System.out.println("-----------------------");
        System.out.println("Use the item:");
        openTheBag();
        System.out.println("-----------------------");
        boolean validInput = false;
        do {
            try {
                int input = scanner.nextInt();

                if (input >= 0 && input < bag.size()) {
                    switch (input) {
                        case 0:
                            useKnife();
                            break;
                        case 1:
                            useTequila();
                            break;
                        case 2:
                            useBottle();
                            break;
                        case 3:
                            if (bag.contains("lighter")) {
                                useLighter();
                            } else {
                                useCocoa();
                            }
                            break;
                        case 4:
                            useDictionary();
                            break;
                        case 5:
                        case 6:
                            if (bag.contains("toxic spear")) {
                                useToxicSpear();
                            } else {
                                prepareToxicSpear();
                            }
                            break;
                    }
                    validInput = true;
                } else
                    System.out.println("Invalid choice buddy. Please try again");
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number.");
                scanner.next();
            }
        } while (!validInput);
    }

    void healthfightResult(){
        if(Game.playerHealth == 0 || Game.jaguarHealth == 0) {
            if (Game.playerHealth == 0) {
                System.out.println("The jaguar killed you...\n");
                Game.exitGame();
            }
            else {
                System.out.println("You kill the jaguar!\n");
            }
        } else
            System.out.println("Keep fighting!\n");
    }
    void printHealthLevels(){
        System.out.println("|| Your health: " + Game.playerHealth + " ||");
        System.out.println("|| Jaguar health: " + Game.jaguarHealth + " || \n");
    }
    public void useKnife(){
        if(Jungle.whereIsPlayerNow.equals("SouthAgain")) {
            System.out.println("The knife is to small to kill jaguar\n");
            System.out.println("You cut him, but he also bitten you!\n"");
            Game.playerHealth -=25;
            Game.jaguarHealth -=10;
            printHealthLevels();
            healthfightResult();
        }
        else
            System.out.println("The item not useful in this situation. Choose another item \n");
    }

    public void useCocoa(){
        Game.playerHealth += 20;
        System.out.println("You eat Cocoa grains. Your health increased to " + Game.playerHealth);
    }
    public void useTequila() {
        if (!ifTequilaDrank) {
            if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
                System.out.println("You are too drunk to fight with jaguar. He is killing you... \n");
                Game.exitGame();
            } else {
                System.out.println("You are drunk. Don't lost your bag and beware of dangers in the jungle!\n");
                ifTequilaDrank = true;
            }
        }
        else
            System.out.println("You drank the entire bottle!");
    }
    public void useBottle() {
        if (Jungle.whereIsPlayerNow.equals("South")) {
            System.out.println("You filled bottle by water. You can drink it later to increase your health! \n");
            ifBottleIsFilled = true;
        }
        else if(Jungle.whereIsPlayerNow.equals("SouthAgain"))
            System.out.println("The item not useful in this situation. Choose another item \n");
        else{
            if (ifBottleIsFilled) {
                Game.playerHealth += 50;
                System.out.println("You drunk the Holy Water. Your health has inceased to " + Game.playerHealth + "\n");
            } else
                System.out.println("The bottle is empty. Find something to drink quickly! \n");
        }
    }

    public void useLighter() {
        if(Jungle.whereIsPlayerNow.equals("East") && Jungle.ifIndianTranslated) {
            Jungle.getIndianHint();
            System.out.println("The Indian also gave you the Cocoa to eat \n");
            bag.set(bag.indexOf("lighter"), "cocoa");
        }
        else
            System.out.println("The item not useful in this situation. Choose another item \n");
    }

    public void useDictionary(){
        if(Jungle.whereIsPlayerNow.equals("East") && !Jungle.ifIndianTranslated) {
            System.out.println("- Dear Gringo, I'll show you the way, but I want your lighter - Indian said \n");
            Jungle.ifIndianTranslated = true;
        }
        else
            System.out.println("The item not useful in this situation. Choose another item \n");
    }

    public void useToxicSpear(){
        if(Jungle.whereIsPlayerNow.equals("SouthAgain")){
            System.out.println("Right choice! \n");
            Game.jaguarHealth = 0;
            printHealthLevels();
            healthfightResult();
        }
        else {
            System.out.println("The item not useful in this situation. Choose another item \n");
        }
    }

    public void prepareToxicSpear() {
        if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
            System.out.println("It's to late for preparing the weapon. The Jaguar killed you");
            Game.exitGame();
        } else {
            addItem("toxic spear");
            removeItem("poison");
            removeItem("wood sticks");
            System.out.println("You have prepared a dangerous toxic spear using the poison and wood sticks");
        }
    }

    public void addItem(String item) {
        bag.add(item);
    }

    public void removeItem(String item) {
        bag.remove(item);
    }

}




