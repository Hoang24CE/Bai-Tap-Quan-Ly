import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        TextArea resultArea = new TextArea();

        Button encryptThreadBtn = new Button("Mã hóa bằng Thread");
        Button decryptThreadBtn = new Button("Giải mã bằng Thread");

        AESEncryption aes = new AESEncryption();
        final String[] lastEncrypted = {""};

        encryptThreadBtn.setOnAction(e -> {
            String data = inputField.getText();
            Thread t = new Thread(() -> {
                try {
                    String result = aes.encrypt(data);
                    lastEncrypted[0] = result;
                    javafx.application.Platform.runLater(() -> resultArea.setText("Encrypted: " + result));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            t.start();
        });

        decryptThreadBtn.setOnAction(e -> {
            Thread t = new Thread(() -> {
                try {
                    String result = aes.decrypt(lastEncrypted[0]);
                    javafx.application.Platform.runLater(() -> resultArea.setText("Decrypted: " + result));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            t.start();
        });

        VBox layout = new VBox(10, new Label("Nhập dữ liệu:"), inputField, encryptThreadBtn, decryptThreadBtn, resultArea);
        primaryStage.setScene(new Scene(layout, 400, 300));
        primaryStage.setTitle("Bài 3 - Mã hóa đa luồng");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
