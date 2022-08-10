package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public Button btnLogIn;

//    public void initialize() throws IOException {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ServerApp.fxml"))));
//        stage.show();
//    }

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        if ("grou".equals(txtUserName.getText())){
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ServerApp.fxml"))));
            stage.show();
        }

        else if("kasun".equals(txtUserName.getText())) {
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ClientApp_01.fxml"))));
            stage2.show();

        }else if("nipuna".equals(txtUserName.getText())){
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ClientApp_02.fxml"))));
            stage2.show();

        }else if("sadun".equals(txtUserName.getText())){
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ClientApp_03.fxml"))));
            stage2.show();
        }else{
            new Alert(Alert.AlertType.WARNING,"User Name Is Not Validated..!").show();
        }

        txtUserName.clear();
    }
}
