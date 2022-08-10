package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp01 {
    final int PORT = 9000;
    public Button btnSent;
    public TextField txtMsg;
    public TextArea txtAreaMsg;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String massage = "", reply = "";

    public void initialize() {
        new Thread(() -> {
            try {
                socket = new Socket("localhost", PORT);
                txtAreaMsg.appendText("Accept Client..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                while (!massage.equals("Exit")) {
                    massage = dataInputStream.readUTF();
                    txtAreaMsg.appendText("\nServer : " + massage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void btnSentOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMsg.getText());
        reply = txtMsg.getText();
        txtAreaMsg.appendText("\nClient-01 : " + reply);
        dataOutputStream.flush();
    }
}
