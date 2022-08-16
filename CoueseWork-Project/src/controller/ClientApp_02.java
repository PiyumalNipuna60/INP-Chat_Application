package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        new Thread(()-> {
        try {
            socket = new Socket("localhost", PORT);

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (!massage.equals("Exit")){
                massage=dataInputStream.readUTF();
                txtAreaMsg.appendText("\n"+massage);
            }

        } catch (Exception e) {
//            e.printStackTrace();
        }

        }).start();
    }

    public void btnSentOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMsg.getText().trim());
        reply=txtMsg.getText();
        txtAreaMsg.appendText("\nClient-02 : " + reply);
        dataOutputStream.flush();

    }

    public void AnotherChatOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.show();
    }
}
