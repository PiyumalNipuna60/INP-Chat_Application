package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp_02 {
    final int PORT = 9002;
    public Button btnSent;
    public TextField txtMsg;
    public TextArea txtAreaMsg;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    Socket socket;

    String massage="", reply="";
    public void initialize() {
        try {
            socket = new Socket("localhost", PORT);
            txtAreaMsg.appendText("Accept Client..!");
            txtAreaMsg.appendText("\n.............................................\n");

            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            while (!massage.equals("Exit")){
                massage=dataInputStream.readUTF();
                txtAreaMsg.appendText("\nServer : " + massage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnSentOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMsg.getText());
        reply=txtMsg.getText();
        txtAreaMsg.appendText("\nClient-01 : " + reply);
        dataOutputStream.flush();
    }
}
