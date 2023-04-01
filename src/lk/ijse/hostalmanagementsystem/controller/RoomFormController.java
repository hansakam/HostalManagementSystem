/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:45 PM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.RoomBO;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {
    public JFXButton Savebtn;
    public JFXButton SearchBtn;
    public JFXButton updateBtn;
    public JFXButton deleteBtn;
    public JFXComboBox roomtypeCombo;
    public TextField Txtqty;
    public TextField Txtkeymoney;
    public TextField Txtrtid;

           /*create a BOFactory mathod*/

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void SaveOnAction(ActionEvent actionEvent) {


        roomBO.saveRoom(new RoomDTO(Txtrtid.getText(),(String) roomtypeCombo.getValue(),Txtkeymoney.getText(),Integer.parseInt(Txtqty.getText())));

    }

    public void SearchOnAction(ActionEvent actionEvent) {

        RoomDTO room = roomBO.searchRoom(Txtrtid.getText());
        if(room!=null){
            FillData(room);
        }

    }

    public void DeleteOnAction(ActionEvent actionEvent) {
        roomBO.deleteRoom(Txtrtid.getText());
    }

    public void updateOnAction(ActionEvent actionEvent) {


        roomBO.updateRoom(new RoomDTO(Txtrtid.getText(),(String) roomtypeCombo.getValue(),Txtkeymoney.getText(),Integer.parseInt(Txtqty.getText())));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

                 /*Load a RoomType in Combobox*/

        ObservableList<String> roomlist = FXCollections.observableArrayList();
        roomlist.addAll("Non-Ac","Non-Ac/Food","Ac","Ac/Food");
        roomtypeCombo.setItems(roomlist);

    }
    public void FillData(RoomDTO dto){
        Txtrtid.setText(dto.getRid());
        roomtypeCombo.setValue(dto.getType());
        Txtkeymoney.setText(dto.getKeymoney());
        Txtqty.setText(String.valueOf(dto.getQty()));
    }
}
