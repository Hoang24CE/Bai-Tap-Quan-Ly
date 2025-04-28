import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP extends Application {
    private TextArea textArea;
    private TextField inputField, ipField, portField;
    private Button sendButton, connectButton;

    private DatagramSocket socket;
    private InetAddress serverAddress;
    private int serverPort;

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("Nhập tin nhắn...");

        ipField = new TextField();
        ipField.setPromptText("Server IP");

        portField = new TextField();
        portField.setPromptText("Server Port");

        sendButton = new Button("Gửi");
        sendButton.setDisable(true);

        connectButton = new Button("Kết nối");

        sendButton.setOnAction(e -> sendMessage());
        connectButton.setOnAction(e -> connectToServer());

        VBox root = new VBox(10, ipField, portField, connectButton, textArea, inputField, sendButton);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setTitle("UDP Chat Client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectToServer() {
        try {
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName(ipField.getText());
            serverPort = Integer.parseInt(portField.getText());
            textArea.appendText("Đã kết nối đến server!\n");
            sendButton.setDisable(false);
            connectButton.setDisable(true);

            // Start receiving thread
            new Thread(() -> {
                byte[] buffer = new byte[1024];
                while (true) {
                    try {
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        socket.receive(packet);
                        String message = new String(packet.getData(), 0, packet.getLength());
                        textArea.appendText(message + "\n");
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
            textArea.appendText("Kết nối thất bại!\n");
        }
    }

    private void sendMessage() {
        try {
            String message = inputField.getText();
            byte[] data = message.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            socket.send(packet);
            inputField.clear();
        } catch (Exception e) {
            e.printStackTrace();
            textArea.appendText("Gửi tin nhắn thất bại!\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
