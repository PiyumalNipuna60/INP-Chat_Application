package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public TextField txtUserName;
    public Button btnLogIn;

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {

        if ("g".equals(txtUserName.getText())){
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ServerApp.fxml"))));
            stage.show();
        }

        else if("k".equals(txtUserName.getText())) {
            Parent scene;
            Stage stage = new Stage();
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("../view/ClientApp_01.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
            txtUserName.clear();

        }else if("n".equals(txtUserName.getText())){
            Parent scene;
            Stage stage = new Stage();
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("../view/ClientApp_02.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
            txtUserName.clear();

        }else if("s".equals(txtUserName.getText())){
            Parent scene;
            Stage stage = new Stage();
            stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource("../view/ClientApp_03.fxml"));
            stage.setScene(new Scene(scene));
            stage.show();
            txtUserName.clear();
        }else{
            new Alert(Alert.AlertType.WARNING,"User Name Is Not Validated..!").show();
            txtUserName.clear();
        }
        txtUserName.clear();
    }
}
