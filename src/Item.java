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
            Game.slowPrint("You put " + item + " to your bag", Game.TEXT_DELAY);
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
                    Game.slowPrint("Invalid choice buddy. Please try again", Game.TEXT_DELAY);
            } catch (InputMismatchException e) {
                Game.slowPrint("Invalid choice. Please enter a number.", Game.TEXT_DELAY);
                scanner.next();
            }
        } while (!validInput);
    }

    public void healthfightResult(){
        if(Game.playerHealth == 0 || Game.jaguarHealth == 0) {
            if (Game.playerHealth == 0) {
                Game.slowPrint("The jaguar killed you...\n", Game.TEXT_DELAY);
                Game.exitGame();
            }
            else {
                Game.slowPrint("You kill the jaguar!\n", Game.TEXT_DELAY);
            }
        } else
            Game.slowPrint("Keep fighting!\n", Game.TEXT_DELAY);
    }
    void printHealthLevels(){
        Game.slowPrint("|| Your health: " + Game.playerHealth + " ||", Game.TEXT_DELAY);
        Game.slowPrint("|| Jaguar health: " + Game.jaguarHealth + " || \n", Game.TEXT_DELAY);
    }
    public void useKnife(){
        if(Jungle.whereIsPlayerNow.equals("SouthAgain")) {
            Game.slowPrint("The knife is to small to kill jaguar\n", Game.TEXT_DELAY);
            Game.slowPrint("You cut him, but he also bitten you!\n", Game.TEXT_DELAY);
            Game.playerHealth -=25;
            Game.jaguarHealth -=10;
            printHealthLevels();
            healthfightResult();
        }
        else
            Game.slowPrint("The item not useful in this situation. Choose another item \n", Game.TEXT_DELAY);
    }

    public void useCocoa(){
        Game.playerHealth += 20;
        Game.slowPrint("You eat Cocoa grains. Your health increased to " + Game.playerHealth, Game.TEXT_DELAY);
    }
    public void useTequila() {
        if (!ifTequilaDrank) {
            if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
                Game.slowPrint("You are too drunk to fight with jaguar. He is killing you... \n", Game.TEXT_DELAY);
                Game.exitGame();
            } else {
                Game.slowPrint("You are drunk. Don't lost your bag and beware of dangers in the jungle!\n", Game.TEXT_DELAY);
                ifTequilaDrank = true;
            }
        }
        else
            Game.slowPrint("You drank the entire bottle!", Game.TEXT_DELAY);
    }
    public void useBottle() {
        if (Jungle.whereIsPlayerNow.equals("South")) {
            Game.slowPrint("You filled bottle by water. You can drink it later to increase your health! \n", Game.TEXT_DELAY);
            ifBottleIsFilled = true;
        }
        else if(Jungle.whereIsPlayerNow.equals("SouthAgain"))
            Game.slowPrint("The item not useful in this situation. Choose another item \n", Game.TEXT_DELAY);
        else{
            if (ifBottleIsFilled) {
                Game.playerHealth += 50;
                Game.slowPrint("You drunk the Holy Water. Your health has inceased to " + Game.playerHealth + "\n", Game.TEXT_DELAY);
            } else
                Game.slowPrint("The bottle is empty. Find something to drink quickly! \n", Game.TEXT_DELAY);
        }
    }

    public void useLighter() {
        if(Jungle.whereIsPlayerNow.equals("East") && Jungle.ifIndianTranslated) {
            Jungle.getIndianHint();
            Game.slowPrint("The Indian also gave you the Cocoa to eat \n", Game.TEXT_DELAY);
            bag.set(bag.indexOf("lighter"), "cocoa");
        }
        else
            Game.slowPrint("The item not useful in this situation. Choose another item \n", Game.TEXT_DELAY);
    }

    public void useDictionary(){
        if(Jungle.whereIsPlayerNow.equals("East") && !Jungle.ifIndianTranslated) {
            Game.slowPrint("- Dear Gringo, I'll show you the way, but I want your lighter - Indian said \n", Game.TEXT_DELAY);
            Jungle.ifIndianTranslated = true;
        }
        else
            Game.slowPrint("The item not useful in this situation. Choose another item \n", Game.TEXT_DELAY);
    }

    public void useToxicSpear(){
        if(Jungle.whereIsPlayerNow.equals("SouthAgain")){
            Game.slowPrint("Right choice! \n", Game.TEXT_DELAY);
            Game.jaguarHealth = 0;
            printHealthLevels();
            healthfightResult();
        }
        else {
            Game.slowPrint("The item not useful in this situation. Choose another item \n", Game.TEXT_DELAY);
        }
    }

    public void prepareToxicSpear() {
        if (Jungle.whereIsPlayerNow.equals("SouthAgain")) {
            Game.slowPrint("It's to late for preparing the weapon. The Jaguar killed you", Game.TEXT_DELAY);
            Game.exitGame();
        } else {
            addItem("toxic spear");
            removeItem("poison");
            removeItem("wood sticks");
            Game.slowPrint("You have prepared a dangerous toxic spear using the poison and wood sticks", Game.TEXT_DELAY );
        }
    }

    public void addItem(String item) {
        bag.add(item);
    }

    public void removeItem(String item) {
        bag.remove(item);
    }

}




