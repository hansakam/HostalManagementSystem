/**
 * @author :Hansaka Malshan
 * created 4/22/2023---12:28 AM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.custom.UserBO;
import lk.ijse.hostalmanagementsystem.utill.Navigation;
import lk.ijse.hostalmanagementsystem.utill.Route;

import java.io.IOException;

public class ForgetpasswordFormController {

    public JFXTextField txtid;
    public JFXTextField txtpassword;
    public JFXButton txtresetbtn;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);


    public AnchorPane pane;

    public void btnresetonAction(ActionEvent actionEvent) {
        boolean user = userBO.UpdatePasswordUser(txtid.getText(), txtpassword.getText());
        if (user){
            new Alert(Alert.AlertType.CONFIRMATION,"Update success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Something Wrong.!").show();

        }
    }

    public void btnbackonAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.LOGINFORM, pane);
    }
}
