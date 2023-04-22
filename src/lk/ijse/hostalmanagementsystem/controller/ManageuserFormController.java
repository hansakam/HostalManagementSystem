/**
 * @author :Hansaka Malshan
 * created 4/20/2023---10:57 PM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.bo.custom.UserBO;
import lk.ijse.hostalmanagementsystem.dto.UserDTO;
import lk.ijse.hostalmanagementsystem.entity.UserEntity;
import lk.ijse.hostalmanagementsystem.utill.Navigation;
import lk.ijse.hostalmanagementsystem.utill.Notifications;
import lk.ijse.hostalmanagementsystem.utill.Route;

import java.io.IOException;
import java.sql.SQLException;

public class ManageuserFormController {

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);


    public AnchorPane pane;
    public JFXTextField txtid;
    public JFXTextField txtpassword;
    public JFXTextField txtemail;
    public JFXTextField txtname;

    public void btnsaveonAction(ActionEvent actionEvent) {
        boolean isAdded = userBO.saveUser(new UserDTO(txtid.getText(),txtname.getText(),txtpassword.getText(),txtemail.getText()));

        if(isAdded){
            String url ="lk/ijse/hostalmanagementsystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Room is Added";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostalmanagementsystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }

    }

    public void btndeleteonAction(ActionEvent actionEvent) {
      boolean isDelete=userBO.deleteUser(txtid.getText());

        if(isDelete){
            String url ="lk/ijse/hostalmanagementsystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Room is Added";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostalmanagementsystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }
    }

    public void btnupdateonAction(ActionEvent actionEvent) {
       boolean isUpdate= userBO.updateUser(new UserDTO(txtid.getText(),txtname.getText(),txtpassword.getText(),txtemail.getText()));

       if(isUpdate){
            String url ="lk/ijse/hostalmanagementsystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Room is Added";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostalmanagementsystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }
    }

    public void btnsearconAction(ActionEvent actionEvent) {
        try {
            UserDTO userDTO = userBO.searchUser(txtid.getText());
            if(userDTO!=null){
                FillData(userDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void  FillData(UserDTO dto){
        txtid.setText(dto.getUserid());
        txtname.setText(dto.getUsername());
        txtpassword.setText(dto.getPassword());
        txtemail.setText(dto.getEmail());
    }

    public void btnbackonAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Route.CREATEREGISTER,pane);
    }
}
