public class TestClass {
    public static void main(String[] args) {
        Jungle jungle = new Jungle();
        jungle.placeDescribingScene();
        jungle.firstBagCheckingScene();
        for (int i = 0; i < 4; i++){
            jungle.getMainChoice();
        }

    }
}
