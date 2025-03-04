public class DiningSimulation {
    public static void main(String[] args) {
        DiningTable table = new DiningTable();

        Thread chef = new Thread(() -> {
            while (true) {
                table.cook();
            }
        });

        Thread customer = new Thread(() -> {
            while (true) {
                table.eat();
            }
        });

        chef.start();
        customer.start();
    }
}