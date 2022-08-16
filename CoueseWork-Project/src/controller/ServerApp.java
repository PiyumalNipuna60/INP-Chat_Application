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


    public void initialize() {
        CheckClient();

    }

    private void CheckClient() {
        new Thread(() -> {
            String massage = "", reply = "";
            try {
                ServerSocket serverSocket = new ServerSocket(9001);
                txtAreaMsg.appendText("Server Start.!");
                Socket localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient-01 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataOutputStream_one = new DataOutputStream(localSocket.getOutputStream());
                dataInputStream_one = new DataInputStream(localSocket.getInputStream());

                while (!massage.equals("Exit")) {
                    massage = dataInputStream_one.readUTF();
                    txtAreaMsg.appendText("\nKasun : " + massage);

                    dataOutputStream_two.writeUTF("Kasun : " + massage);
                    dataOutputStream_three.writeUTF("Kasun : " + massage);

                    dataOutputStream_two.flush();
                    dataOutputStream_three.flush();
                }

//                if (massage.equals("Exit")) {
//                    System.out.println("Client 1 left the chat");
//
//                    dataOutputStream_two.writeUTF("Kasun left the chat");
//                    dataOutputStream_three.writeUTF("Kasun left the chat");
//
//                    serverSocket.close();
//                    localSocket.close();
//                    dataOutputStream_one.close();
//                    dataInputStream_one.close();
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


        //======================Client 02=================

        new Thread(() -> {
            String massage = "", reply = "";
            try {
                ServerSocket serverSocket = new ServerSocket(9002);
                txtAreaMsg.appendText("Server Start.!");
                Socket localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient-02 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataOutputStream_two = new DataOutputStream(localSocket.getOutputStream());
                dataInputStream_two = new DataInputStream(localSocket.getInputStream());

                while (!massage.equals("Exit")) {
                    massage = dataInputStream_two.readUTF();
                    txtAreaMsg.appendText("\nNipuna : " + massage);

                    dataOutputStream_one.writeUTF("Nipuna : " + massage);
                    dataOutputStream_one.flush();
                    dataOutputStream_three.writeUTF("Nipuna : " + massage);
                    dataOutputStream_three.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        //======================Client 03=================

        new Thread(() -> {
            String massage = "", reply = "";
            try {
                ServerSocket serverSocket = new ServerSocket(9003);
                txtAreaMsg.appendText("Server Start.!");
                Socket localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient-03 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataOutputStream_three = new DataOutputStream(localSocket.getOutputStream());
                dataInputStream_three = new DataInputStream(localSocket.getInputStream());

                while (!massage.equals("Exit")) {
                    massage = dataInputStream_three.readUTF();
                    txtAreaMsg.appendText("\nSadun : " + massage);

                    dataOutputStream_one.writeUTF("Sadun : " + massage);
                    dataOutputStream_one.flush();
                    dataOutputStream_two.writeUTF("Sadun : " + massage);
                    dataOutputStream_two.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void btnSentOnAction(ActionEvent actionEvent) {
    }
}
