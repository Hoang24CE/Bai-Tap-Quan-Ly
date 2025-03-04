import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DeadlockFixed {
    static final Lock resource1 = new ReentrantLock();
    static final Lock resource2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (resource1.tryLock()) {
                    try {
                        System.out.println("Thread 1: Locked resource 1");
                        Thread.sleep(50);
                        if (resource2.tryLock()) {
                            try {
                                System.out.println("Thread 1: Locked resource 2");
                                break;
                            } finally {
                                resource2.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        resource1.unlock();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (resource2.tryLock()) {
                    try {
                        System.out.println("Thread 2: Locked resource 2");
                        Thread.sleep(50);
                        if (resource1.tryLock()) {
                            try {
                                System.out.println("Thread 2: Locked resource 1");
                                break;
                            } finally {
                                resource1.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        resource2.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
