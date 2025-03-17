import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FileReaderThread implements Runnable {
    private String filePath;
    private long start;
    private long end;

    public FileReaderThread(String filePath, long start, long end) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            file.seek(start); // Di chuyển con trỏ tới vị trí bắt đầu
            byte[] buffer = new byte[1024]; // Bộ nhớ đệm
            long bytesRead = start;

            while (bytesRead < end) {
                int len = (int) Math.min(buffer.length, end - bytesRead);
                file.read(buffer, 0, len);
                String content = new String(buffer, 0, len);
                System.out.println(Thread.currentThread().getName() + " đọc:\n" + content);
                bytesRead += len;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class MultiThreadFileReader {
    public static void main(String[] args) {
        String filePath = "largefile"; // File lớn cần đọc
        int numThreads = 4; // Số lượng Thread

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
            long fileSize = file.length(); // Lấy kích thước file
            long chunkSize = fileSize / numThreads; // Chia đều file thành các phần nhỏ

            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            for (int i = 0; i < numThreads; i++) {
                long start = i * chunkSize;
                long end = (i == numThreads - 1) ? fileSize : start + chunkSize;
                executor.execute(new FileReaderThread(filePath, start, end));
            }

            executor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
