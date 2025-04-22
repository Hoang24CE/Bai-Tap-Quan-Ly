import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.Button;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField inputField = new TextField();
        ComboBox<String> algorithmBox = new ComboBox<>();
        algorithmBox.getItems().addAll("MD5", "SHA-256");
        algorithmBox.setValue("MD5");

        Button hashBtn = new Button("Hash");
        TextArea output = new TextArea();

        hashBtn.setOnAction(e -> {
            try {
                String algo = algorithmBox.getValue();
                String hashed = HashUtil.hash(inputField.getText(), algo);
                output.setText(hashed);
            } catch (Exception ex) {
                output.setText("Lỗi: " + ex.getMessage());
            }
        });

        VBox layout = new VBox(10, new Label("Nhập mật khẩu:"), inputField, algorithmBox, hashBtn, output);
        primaryStage.setScene(new Scene(layout, 400, 250));
        primaryStage.setTitle("Mã hóa mật khẩu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
