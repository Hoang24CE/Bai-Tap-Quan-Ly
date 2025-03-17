public class URLDownloader {
    public static void main(String[] args) {
        String url = "https://www.w3.org/TR/PNG/iso_8859-1.txt"; // URL một file text mẫu
        String outputFile = "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B10\\src\\downloaded.txt";

        DownloadThread thread = new DownloadThread(url, outputFile);
        thread.start();

        try {
            thread.join(); // Chờ thread tải xong
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tải dữ liệu hoàn tất.");
    }
}