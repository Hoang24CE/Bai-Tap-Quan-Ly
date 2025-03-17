import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

class DownloadThread extends Thread {
    private String url;
    private String outputFile;

    public DownloadThread(String url, String outputFile) {
        this.url = url;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("[Thread] Đã tải xong nội dung từ URL vào " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}