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

    DataOutputStream dataOutputStream_one;
    DataInputStream dataInputStream_one;

    DataOutputStream dataOutputStream_two;
    DataInputStream dataInputStream_two;

    DataOutputStream dataOutputStream_three;
    DataInputStream dataInputStream_three;


    String massage="", reply="";

    public void initialize() {
        CheckClient();

    }

    private void CheckClient(){
        new Thread(()->{
            try {
                ServerSocket serverSocket = new ServerSocket(9001);
                txtAreaMsg.appendText("Server Start.!");
                Socket localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient-01 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataOutputStream_one=new DataOutputStream(localSocket.getOutputStream());
                dataInputStream_one=new DataInputStream(localSocket.getInputStream());

                while (!massage.equals("Exit")){
                    massage=dataInputStream_one.readUTF();
                    txtAreaMsg.appendText("\nClient-01 : " + massage);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void btnSentOnAction(ActionEvent actionEvent) {
    }
}
