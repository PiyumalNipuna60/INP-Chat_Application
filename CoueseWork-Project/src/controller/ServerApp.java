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

    Socket localSocket;

    String massage = "", reply = "";
    String massage2 = "";
    String massage3 = "";

    public void initialize() {
        CheckClient();
    }

    private void CheckClient() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(9001);
                txtAreaMsg.appendText("Server Start.!");
//                Socket localSocket = serverSocket.accept();
                localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient-01 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataInputStream_one = new DataInputStream(localSocket.getInputStream());
                dataOutputStream_one = new DataOutputStream(localSocket.getOutputStream());

                while (!massage.equals("Exit")) {
                    massage = dataInputStream_one.readUTF();
                    txtAreaMsg.appendText("\nClient_01 : " + massage);

                    dataOutputStream_two.writeUTF("Client_01 : " + massage.trim());
                    dataOutputStream_three.writeUTF("Client_01 : " + massage.trim());

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
            try {
                ServerSocket serverSocket = new ServerSocket(9002);
                txtAreaMsg.appendText("Server Start.!");
//                Socket localSocket = serverSocket.accept();
                localSocket=serverSocket.accept();
                txtAreaMsg.appendText("\nClient-02 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataInputStream_two = new DataInputStream(localSocket.getInputStream());
                dataOutputStream_two = new DataOutputStream(localSocket.getOutputStream());

                while (!massage2.equals("Exit")) {
                    massage2 = dataInputStream_two.readUTF();
                    txtAreaMsg.appendText("\nClient_02 : " + massage2);

                    dataOutputStream_one.writeUTF("Client_02 : " + massage2.trim());
                    dataOutputStream_one.flush();
                    dataOutputStream_three.writeUTF("Client_02 : " + massage2.trim());
                    dataOutputStream_three.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        //======================Client 03=================

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(9003);
                txtAreaMsg.appendText("Server Start.!");
//                Socket localSocket = serverSocket.accept();
                localSocket = serverSocket.accept();
                txtAreaMsg.appendText("\nClient-03 Connected..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataInputStream_three = new DataInputStream(localSocket.getInputStream());
                dataOutputStream_three = new DataOutputStream(localSocket.getOutputStream());

                while (!massage3.equals("Exit")) {
                    massage3 = dataInputStream_three.readUTF();
                    txtAreaMsg.appendText("\nclient-03 : " + massage3);

                    dataOutputStream_one.writeUTF("client-03 : " + massage3.trim());
                    dataOutputStream_one.flush();
                    dataOutputStream_two.writeUTF("client-03 : " + massage3.trim());
                    dataOutputStream_two.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void btnSentOnAction(ActionEvent actionEvent) throws IOException {
//        dataOutputStream_one.writeUTF(txtMsg.getText().trim());
//        reply = txtMsg.getText();
//        txtAreaMsg.appendText("\nClient-01 : " + reply);
//        dataOutputStream.flush();

        dataOutputStream_one.writeUTF("Server : "+txtMsg.getText().trim());
        dataOutputStream_one.flush();

        dataOutputStream_two.writeUTF("Server : "+txtMsg.getText().trim());
        dataOutputStream_two.flush();

        dataOutputStream_three.writeUTF("Server : "+txtMsg.getText().trim());
        dataOutputStream_three.flush();
    }
}
