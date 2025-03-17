import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class KeyboardWriterThread extends Thread {
    private static final String FILE_NAME = "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B7\\src\\output.txt";

    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Nhập nội dung để ghi vào file (gõ 'EXIT' để thoát):");

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();

                if ("EXIT".equalsIgnoreCase(input)) {
                    System.out.println("Kết thúc ghi file.");
                    break;
                }

                writer.write(input);
                writer.newLine();
                writer.flush(); // Đảm bảo dữ liệu được ghi ngay vào file
                System.out.println("[Writer] Đã ghi vào file: " + input);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

