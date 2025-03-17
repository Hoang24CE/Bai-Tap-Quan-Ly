import java.io.*;

class CharacterCountThread extends Thread {
    private String inputFile;
    private String outputFile;

    public CharacterCountThread(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        int charCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                charCount++; // Đếm từng ký tự
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("Số ký tự trong file: " + charCount);
            System.out.println("[Thread] Đã ghi kết quả vào " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}