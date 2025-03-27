package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Đảm bảo đường dẫn chính xác
            URL fxmlLocation = getClass().getResource("/LibraryView.fxml");
            if (fxmlLocation == null) {
                throw new RuntimeException("Không tìm thấy file LibraryView.fxml! Kiểm tra lại đường dẫn.");
            }

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            Parent root = loader.load();

            primaryStage.setTitle("Quản lý Thư Viện");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi tải giao diện: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
