import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ChatClient extends Application {
    private TextArea chatArea;
    private TextField inputField, ipField, portField;
    private Button sendButton, connectButton;

    private Socket socket;
    private PrintWriter out;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        chatArea = new TextArea();
        chatArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("Nhập tin nhắn...");

        sendButton = new Button("Gửi");
        sendButton.setOnAction(e -> sendMessage());

        HBox inputBox = new HBox(10, inputField, sendButton);

        ipField = new TextField("localhost");
        ipField.setPromptText("IP Server");

        portField = new TextField("12345");
        portField.setPromptText("Port");

        connectButton = new Button("Kết nối");
        connectButton.setOnAction(e -> connectToServer());

        HBox connectBox = new HBox(10, ipField, portField, connectButton);

        VBox root = new VBox(10, chatArea, connectBox, inputBox);
        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("JavaFX Chat Client");
        stage.setScene(scene);
        stage.show();
    }

    private void connectToServer() {
        try {
            socket = new Socket(ipField.getText(), Integer.parseInt(portField.getText()));
            out = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new Receiver(socket)).start();
            chatArea.appendText("Đã kết nối đến server.\n");
        } catch (IOException e) {
            chatArea.appendText("Không thể kết nối đến server.\n");
        }
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (out != null && !message.isEmpty()) {
            out.println(message);
            inputField.clear();
        }
    }

    class Receiver implements Runnable {
        private BufferedReader in;

        public Receiver(Socket socket) throws IOException {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    String finalMessage = message;
                    Platform.runLater(() -> chatArea.appendText(finalMessage + "\n"));
                }
            } catch (IOException e) {
                Platform.runLater(() -> chatArea.appendText("Mất kết nối đến server.\n"));
            }
        }
    }
}
