class CountdownThread extends Thread {
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println("Countdown: " + i);
            try {
                Thread.sleep(1000); // Dừng 1 giây
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread bị gián đoạn!");
            }
        }
    }
}