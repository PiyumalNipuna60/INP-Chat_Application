package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class ClientApp01 {
    public Button btnSent;
    public TextField txtMsg;
    public TextArea txtAreaMsg;
    Socket socket;
    final int PORT=9000;

    public void initialize(){
        new Thread(()->{
            try {
                socket=new Socket("localhost",PORT);


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void btnSentOnAction(ActionEvent actionEvent) {

    }
}
