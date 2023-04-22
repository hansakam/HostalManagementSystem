/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:45 PM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.custom.RoomBO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.tm.RoomTM;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;
import lk.ijse.hostalmanagementsystem.utill.Notifications;
import lk.ijse.hostalmanagementsystem.utill.ValidationUtill;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class RoomFormController implements Initializable {
    public JFXButton Savebtn;
    public JFXButton SearchBtn;
    public JFXButton updateBtn;
    public JFXButton deleteBtn;
    public TextField Txtqty;
    public TextField Txtkeymoney;
    public TextField Txtrtid;
    public TableView<RoomTM> tblroom;
    public TableColumn tblcolrid;
    public TableColumn tblcolroomtype;
    public TableColumn tblcolkeymoney;
    public TableColumn tblcolqty;
    public JFXTextField txtroomtypeid;
    public JFXTextField txtrRoomtype;

                    /*create a BOFactory mathod*/

    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    private final LinkedHashMap<JFXTextField, Pattern> RegexMap = new LinkedHashMap<>();


    public void SaveOnAction(ActionEvent actionEvent) {


        boolean isAdded=roomBO.saveRoom(new RoomDTO(txtroomtypeid.getText(),txtrRoomtype.getText(),Txtkeymoney.getText(),Integer.parseInt(Txtqty.getText())));

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

    public void SearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        RoomDTO room = roomBO.searchRoom(txtroomtypeid.getText());
        if(room!=null){
            FillData(room);
        }

    }

    public void DeleteOnAction(ActionEvent actionEvent) {

        boolean isDelete= roomBO.deleteRoom(txtroomtypeid.getText());
        if(isDelete){
            String url ="lk/ijse/hostalmanagementsystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Room is Delete";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostalmanagementsystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {


      boolean isUpdate=  roomBO.updateRoom(new RoomDTO(txtroomtypeid.getText(), txtrRoomtype.getText(),Txtkeymoney.getText(),Integer.parseInt(Txtqty.getText())));
        if(isUpdate){
            String url ="lk/ijse/hostalmanagementsystem/assets/notification.png" ;
            String titel = "Successful";
            String text = "Room is Delete";
            Notifications.showNotification(url,text,titel);
        }else {
            String url ="lk/ijse/hostalmanagementsystem/assets/sorry.png" ;
            String titel = "error";
            String text = "Somthing was wrong";
            Notifications.showNotification(url,text,titel);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoadTable();
        initUi();
        getarraylist();

        RegexMap.put(txtroomtypeid,Pattern.compile("^(RM-)[0-9]{4}$"));
        RegexMap.put((JFXTextField) Txtkeymoney,Pattern.compile("^[0-9]+([.]{1}[0-9]{1,2})?+$"));
        RegexMap.put((JFXTextField) Txtqty,Pattern.compile("^[0-9]+$"));

    }
    public void FillData(RoomDTO dto){
        txtroomtypeid.setText(dto.getRid());
        txtrRoomtype.setText(dto.getType());
        Txtkeymoney.setText(dto.getKeymoney());
        Txtqty.setText(String.valueOf(dto.getQty()));
    }
    private void initUi(){
        Txtqty.clear();
        Txtkeymoney.clear();
    }

    public void getarraylist(){
        ObservableList<RoomTM> allroom = roomBO.getAllROOm();
        tblroom.setItems(allroom );

    }
    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
        Object validate = ValidationUtill.Validate(RegexMap,Savebtn);
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if (validate instanceof JFXTextField) {
                ((JFXTextField) validate).requestFocus();
            } else {
                Savebtn.fire();
            }
        }
    }
    public void LoadTable(){

        tblcolrid.setCellValueFactory(new PropertyValueFactory("rid"));
        tblcolroomtype.setCellValueFactory(new PropertyValueFactory("type"));
        tblcolkeymoney.setCellValueFactory(new PropertyValueFactory("keymoney"));
        tblcolqty.setCellValueFactory(new PropertyValueFactory("qty"));


    }

}
