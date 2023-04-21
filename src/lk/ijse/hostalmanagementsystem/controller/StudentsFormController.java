/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:44 PM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import lk.ijse.hostalmanagementsystem.bo.custom.StudentBO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;
import lk.ijse.hostalmanagementsystem.utill.ValidationUtill;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class StudentsFormController implements Initializable {

    public JFXComboBox Combogender;
    public TextField TxtDob;
    public TextField TxtContact;
    public TextField TxtAddress;
    public TextField TxtSname;
    public TextField TxtSid;
    public JFXDatePicker combodatepic;
    public TableView tblstudenttable;
    public TableColumn tblcolgender;
    public TableColumn tblcoldob;
    public TableColumn tblcolcontact;
    public TableColumn tblcoladdress;
    public TableColumn tblcolname;
    public TableColumn tblcolsid;

    /*Create a BOFactory mathod*/
    private final StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);
    private final LinkedHashMap<JFXTextField, Pattern> RegexMap = new LinkedHashMap<>();

    public JFXButton addId;
    public JFXButton deleteid;
    public JFXButton update;



    public void addOnAction(ActionEvent actionEvent) {


        studentBO.saveStudent(new StudentDTO(TxtSid.getText(),TxtSname.getText(),TxtAddress.getText(),TxtContact.getText(),combodatepic.getValue(),(String) Combogender.getValue()));
        initUi();
        getarraylist();

    }

    public void updateOnAction(ActionEvent actionEvent) {


        studentBO.updateStudent(new StudentDTO(TxtSid.getText(),TxtSname.getText(),TxtAddress.getText(),TxtContact.getText(),combodatepic.getValue(),(String) Combogender.getValue()));
        initUi();
        getarraylist();
    }

    public void deleteOnAction(ActionEvent actionEvent) {

        studentBO.deleteStudent(TxtSid.getText());
        initUi();
        getarraylist();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

                /*Load a Gender in Combobox*/

        ObservableList<String> genderlist = FXCollections.observableArrayList();
        genderlist.addAll("male","Female");
        Combogender.setItems(genderlist);

        getarraylist();
        initUi();
        LoadTable();

        RegexMap.put((JFXTextField) TxtSid,Pattern.compile("^[S 0-9-]+$"));
        //RegexMap.put((JFXTextField) TxtSname,Pattern.compile(" ^[A-z ]+$"));
        RegexMap.put((JFXTextField) TxtContact,Pattern.compile("^[0-9]{10,11}$"));
        RegexMap.put((JFXTextField) TxtAddress,Pattern.compile("^[A-z1-9 /,.-]+$"));



    }

    public void searchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        StudentDTO student = studentBO.searchStudent(TxtSid.getText());
        if(student!=null){
            FillData(student);
        }

    }

    public  void FillData(StudentDTO dto){
        TxtSid.setText(dto.getSid());
        TxtSname.setText(dto.getName());
        TxtAddress.setText(dto.getAddress());
        TxtContact.setText(dto.getContact());
        combodatepic.setValue(dto.getDob());
        Combogender.setValue(dto.getGender());
    }


    private void initUi(){
        TxtSid.clear();
        TxtSname.clear();
        TxtAddress.clear();
        TxtContact.clear();

    }
   public void LoadTable(){

        tblcolsid.setCellValueFactory(new PropertyValueFactory("sid"));
        tblcolname.setCellValueFactory(new PropertyValueFactory("name"));
        tblcoladdress.setCellValueFactory(new PropertyValueFactory("address"));
        tblcolcontact.setCellValueFactory(new PropertyValueFactory("contact"));
        tblcoldob.setCellValueFactory(new PropertyValueFactory("dob"));
        tblcolgender.setCellValueFactory(new PropertyValueFactory("gender"));

    }
    public void getarraylist(){
        ObservableList<StudentTM> allStudent = studentBO.getAllStudent();
        tblstudenttable.setItems(allStudent);

    }

    public void validateFieldsOnKeyRelease(KeyEvent keyEvent) {
        Object validate = ValidationUtill.Validate(RegexMap, addId);
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if (validate instanceof JFXTextField) {
                ((JFXTextField) validate).requestFocus();
            } else {
                addId.fire();
            }
        }
}


}
