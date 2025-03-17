public class CharacterCounter {
    public static void main(String[] args) {
        String inputFile = "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B9\\src\\input.txt";
        String outputFile = "C:\\VKU_HOC_TAP\\Nam1\\Ki2\\Lap Trinh JAVA (14)\\Bai Tap\\Quan_Ly\\BaiTap Iostream - Thread\\B9\\src\\output.txt";

        CharacterCountThread thread = new CharacterCountThread(inputFile, outputFile);
        thread.start();

        try {
            thread.join(); // Chờ thread hoàn thành
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chương trình kết thúc.");
    }
}