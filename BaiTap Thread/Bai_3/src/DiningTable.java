import java.util.LinkedList;
import java.util.Queue;

class DiningTable {
    private final int CAPACITY = 5;
    private final Queue<String> table = new LinkedList<>();

    public synchronized void cook() {
        try {
            while (table.size() == CAPACITY) {
                System.out.println("Bàn đầy, đầu bếp chờ...");
                wait();
            }
            Thread.sleep(2000); // Mô phỏng thời gian nấu ăn
            String dish = "Món ăn " + (table.size() + 1);
            table.add(dish);
            System.out.println("Đầu bếp đã nấu: " + dish);
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void eat() {
        try {
            while (table.isEmpty()) {
                System.out.println("Bàn trống, khách chờ...");
                wait();
            }
            Thread.sleep(3000);
            String dish = table.poll();
            System.out.println("Khách đã ăn: " + dish);
            notify();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}