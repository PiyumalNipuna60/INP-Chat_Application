package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerApp {
    public Button btnSent;
    public TextArea txtAreaMsg;
    public TextField txtMsg;
    final int PORT=7000;
    DataOutputStream dataOutputStream;

    String massage="", reply="";

    public void initialize() {


        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                txtAreaMsg.appendText("Server Start.!");
                Socket localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                 dataOutputStream=new DataOutputStream(localSocket.getOutputStream());
                DataInputStream dataInputStream=new DataInputStream(localSocket.getInputStream());

                while (!massage.equals("Exit")){
                    massage=dataInputStream.readUTF();
                    txtAreaMsg.appendText("\nClient-01 : " + massage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void CheckClient(){

    }

    public void btnSentOnAction(ActionEvent actionEvent) {
    }
}
