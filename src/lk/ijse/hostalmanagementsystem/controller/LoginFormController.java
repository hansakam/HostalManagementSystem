/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:41 PM
 */
package lk.ijse.hostalmanagementsystem.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostalmanagementsystem.utill.Navigation;
import lk.ijse.hostalmanagementsystem.utill.Route;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class LoginFormController implements Initializable {


    public JFXButton logid;
    public AnchorPane pane;
    public JFXTextField userid;
    public JFXTextField passwordId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }


    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.DASHBOARDFORM,pane);
    }

    public void userOnAction(ActionEvent actionEvent) {
    }

    public void paswordOnAction(ActionEvent actionEvent) {
    }
}
