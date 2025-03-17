import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class LoggerThread extends Thread {
    private static final String LOG_FILE = "log.txt";
    private static BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;

    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            while (running || !logQueue.isEmpty()) {
                String logMessage = logQueue.poll(); // Lấy log từ hàng đợi
                if (logMessage != null) {
                    writer.write(logMessage);
                    writer.newLine();
                    writer.flush();
                    System.out.println("[Logger] Ghi log: " + logMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            logQueue.put("[" + timestamp + "] " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopLogging() {
        running = false;
    }
}
