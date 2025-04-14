import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField input = new TextField();
        ComboBox<String> algorithmBox = new ComboBox<>();
        algorithmBox.getItems().addAll("AES", "RSA");
        algorithmBox.setValue("AES");

        Button encryptBtn = new Button("Encrypt");
        Button decryptBtn = new Button("Decrypt");
        TextArea output = new TextArea();

        Encryptable[] encryptor = new Encryptable[1];

        encryptBtn.setOnAction(e -> {
            try {
                String algo = algorithmBox.getValue();
                encryptor[0] = algo.equals("AES") ? new AESEncryption() : new RSAEncryption();
                String result = encryptor[0].encrypt(input.getText());
                output.setText(result);
            } catch (Exception ex) {
                output.setText("Lỗi mã hóa: " + ex.getMessage());
            }
        });

        decryptBtn.setOnAction(e -> {
            try {
                if (encryptor[0] == null) {
                    output.setText("Bạn phải mã hóa trước.");
                    return;
                }
                String result = encryptor[0].decrypt(output.getText());
                output.setText(result);
            } catch (Exception ex) {
                output.setText("Lỗi giải mã: " + ex.getMessage());
            }
        });

        VBox root = new VBox(10, new Label("Nhập dữ liệu:"), input, algorithmBox, encryptBtn, decryptBtn, new Label("Kết quả:"), output);
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Bài 2 - AES/RSA với Interface");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
