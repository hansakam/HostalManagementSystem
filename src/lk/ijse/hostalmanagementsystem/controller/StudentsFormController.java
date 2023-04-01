/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:44 PM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.StudentBO;
import lk.ijse.hostalmanagementsystem.dto.Studentdto;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentsFormController implements Initializable {

    public JFXComboBox Combogender;
    public TextField TxtDob;
    public TextField TxtContact;
    public TextField TxtAddress;
    public TextField TxtSname;
    public TextField TxtSid;
    public JFXDatePicker combodatepic;

            /*Create a BOFactory mathod*/
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    public JFXButton addId;
    public JFXButton deleteid;
    public JFXButton update;



    public void addOnAction(ActionEvent actionEvent) {


        studentBO.saveStudent(new Studentdto(TxtSid.getText(),TxtSname.getText(),TxtAddress.getText(),TxtContact.getText(),combodatepic.getValue(),(String) Combogender.getValue()));


    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

                /*Load a Gender in Combobox*/

        ObservableList<String> genderlist = FXCollections.observableArrayList();
        genderlist.addAll("male","Female");
        Combogender.setItems(genderlist);


    }
}
