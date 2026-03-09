public class Main {
    public static void main(String[] args) {
        eRyder bike1 = new eRyder();
        bike1.printBikeDetails();

        eRyder bike2 = new eRyder("bike1", 85, true, 125.5);
        bike2.ride();
        bike2.printBikeDetails();
    }
}
