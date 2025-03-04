class Visibility {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("Flag changed!");
        });

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        flag = true;
    }
}
