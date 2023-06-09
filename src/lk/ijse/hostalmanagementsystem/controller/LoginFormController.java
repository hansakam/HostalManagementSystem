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
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.custom.UserBO;
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
    public JFXButton btnresetaccount;
    public JFXButton btncreateaccount;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }


    public void btnresetaccountonAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.FORGOTPASSWORD,pane);
    }

    public void btncreateaccountOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.REGISTER,pane);
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {


        if(userBO.checkPassword(userid.getText(),passwordId.getText())){

            Navigation.navigate(Route.DASHBOARDFORM,pane);
        }

    }
}
