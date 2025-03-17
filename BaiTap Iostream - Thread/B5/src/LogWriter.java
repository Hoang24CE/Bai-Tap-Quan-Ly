public class LogWriter {
    public static void main(String[] args) {
        LoggerThread logger = new LoggerThread();
        logger.start();

        // Ghi một số log vào file
        logger.log("Chương trình bắt đầu.");
        logger.log("Đang thực hiện một số thao tác...");
        logger.log("Hoàn tất xử lý.");

        // Đợi vài giây để log được ghi vào file
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Dừng thread ghi log
        logger.stopLogging();
    }
}