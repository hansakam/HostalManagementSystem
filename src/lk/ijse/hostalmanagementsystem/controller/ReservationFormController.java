/**
 * @author :Hansaka Malshan
 * created 3/30/2023---6:48 PM
 */
package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.bo.custom.ReservationBO;
import lk.ijse.hostalmanagementsystem.bo.custom.RoomBO;
import lk.ijse.hostalmanagementsystem.bo.custom.StudentBO;
import lk.ijse.hostalmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {

    public JFXComboBox statusId;
    public Label residLbl11;
    public JFXComboBox comboroomtype;
    public JFXComboBox combostudentid;
    public Label lbldate;
    public Label lblresid;
    public JFXComboBox <String>combostatus;
    public JFXDatePicker resdateid;
    public JFXComboBox<String> cmbStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public JFXTextField txtDOB;
    public JFXTextField txtGender;
    public JFXComboBox <String>cmbRoomId;
    public JFXTextField txtRoomType;
    public JFXTextField txtMonthlyRent;
    public JFXTextField txtQty;
    public JFXTextField txtKeyMoney;
    public Label llbResId;
    public JFXButton btnReserve;

    private String RegID;

    /*Create a BOFactory mathod*/


    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);


    public void BTNsaveOnAction(ActionEvent actionEvent) {

        double roomFee = Double.parseDouble(txtMonthlyRent.getText());
        double advance = Double.parseDouble(txtKeyMoney.getText());
        String status = String.valueOf(roomFee - advance);

        boolean b = saveReserve(RegID, LocalDate.now(),cmbStudentId.getValue(), cmbRoomId.getValue(),status, txtMonthlyRent.getText(), advance);
        if (b) {
           // NotificationController.SuccessfulTableNotification("Room Reserve", "Room Reserved in student ");
        } else {
            System.out.println(b);
            //NotificationController.UnSuccessfulTableNotification("Room Reserve", "Room Reserved in student ");
        }

        RegID = generateNewOrderId();
        llbResId.setText(RegID);
        cmbRoomId.getSelectionModel().clearSelection();
        cmbStudentId.getSelectionModel().clearSelection();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtQty.clear();
        txtMonthlyRent.clear();
        txtStudentName.clear();
        txtAddress.clear();
        txtDOB.clear();
        txtGender.clear();
        txtContactNo.clear();
    }



    private String generateNewOrderId() {
        try {
            return reservationBO.generateNewReserveID();
        } catch (SQLException e) {
           /* NotificationController.Warring("Generate Order Id", "Failed to generate a new order id...");*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "REG-001";
    }

    public boolean saveReserve(String resId,LocalDate orderDate, String stId, String roomId, String status ,String keyMoney, double advance) {
        try {
            return reservationBO.PurchaseRoom(new ReservationDTO(resId, orderDate, stId, roomId, status,keyMoney, advance ));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void enableOrDisableRegisterButton() {
        btnReserve.setDisable(cmbRoomId.getSelectionModel().getSelectedItem() == null);

    }

    private boolean exitStudent(String id) throws SQLException, ClassNotFoundException {
        return reservationBO.checkStudentIsAvailable(id);
    }

    private boolean exitRooms(String id) throws SQLException, ClassNotFoundException {
        return reservationBO.checkRoomIsAvailable(id);
    }

    private void loadAllStudentIds() {
        try {
            ArrayList<StudentDTO> all = reservationBO.getAllStudents();
            for (StudentDTO studentDTO : all) {
                cmbStudentId.getItems().add(studentDTO.getSid());
            }

        } catch (SQLException e) {
            //NotificationController.Warring("Student Load", "Failed to load customer ids.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllRoomIds() {
        try {
            ArrayList<RoomDTO> all = reservationBO.getAllRooms();
            for (RoomDTO roomDTO : all) {
                cmbRoomId.getItems().add(roomDTO.getRid());
            }
        } catch (SQLException e) {
            //NotificationController.Warring("Rooms Load", "Failed to load customer ids.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateNewOrderId();
        loadAllRoomIds();
        loadAllStudentIds();

        RegID = generateNewOrderId();
        llbResId.setText(RegID);


        //---------Student to Combo-------------//
        cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            enableOrDisableRegisterButton();

            if (newValue != null) {
                try {
                    if (!exitStudent(newValue + "")) {
                       // NotificationController.WarringError("Search Student Warning", newValue, "There is no such student associated with the ");
                    }
                    /*Search student*/
                    StudentDTO studentDTO = reservationBO.searchStudent(newValue + "");
                    txtStudentName.setText(studentDTO.getName());
                    txtAddress.setText(studentDTO.getAddress());
                    txtDOB.setText(studentDTO.getDob() + "");
                    txtGender.setText(studentDTO.getGender());
                    txtContactNo.setText(studentDTO.getContact());

                } catch (SQLException | ClassNotFoundException e) {
                    //NotificationController.WarringError("Search Student Warning", newValue, "Failed to find the Student ");
                }
            } else {
                txtStudentName.clear();
            }
        });

        //---------Room to Combo-------------//
        cmbRoomId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newRoomId) -> {
            btnReserve.setDisable(newRoomId == null);


            if (newRoomId != null) {
                try {
                    exitRooms(newRoomId + "");
                    RoomDTO room = reservationBO.searchRoom(newRoomId + "");
                    txtRoomType.setText(room.getType());
                    txtQty.setText(String.valueOf(room.getQty()));
                    txtMonthlyRent.setText(room.getKeymoney());

                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }

            } else {
                txtMonthlyRent.clear();
                txtQty.clear();
                txtStudentName.clear();
                txtMonthlyRent.clear();
            }
        });
    }
}
