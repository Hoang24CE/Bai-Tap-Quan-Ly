import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Starvation {
    private static final Lock lock = new ReentrantLock(true); // Fair lock

    public static void main(String[] args) {
        Thread highPriority = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    System.out.println("High priority thread running...");
                } finally {
                    lock.unlock();
                    Thread.yield(); // Nhường CPU cho thread khác
                }
            }
        });

        Thread lowPriority = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    System.out.println("Low priority thread running...");
                } finally {
                    lock.unlock();
                }
            }
        });

        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
