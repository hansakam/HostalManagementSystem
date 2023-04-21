/**
 * @author :Hansaka Malshan
 * created 3/31/2023---6:57 PM
 */

package lk.ijse.hostalmanagementsystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.hostalmanagementsystem.bo.BOFactory;
import lk.ijse.hostalmanagementsystem.bo.custom.ReservationBO;
import lk.ijse.hostalmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostalmanagementsystem.tm.PaymentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PaymentFormController implements Initializable {
    public TableView<PaymentTM> tblpaymentDetails;
    public TableColumn tblcreservationid;
    public TableColumn tblstudentid;
    public TableColumn tblcstudentname;
    public TableColumn tblcromtypeid;
    public TableColumn tblroomtype;
    public TableColumn tblcpaymentid;
    public TableColumn tblcstatus;
    public JFXTextField txtsearchid;


    ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVATION);

    /*    private void loadAllReserve() {
            tblpaymentDetails.getItems().clear();


            try {
                ArrayList<ReservationDTO> allReserve = reservationBO.getAllReserve();
                for (ReservationDTO reservationDTO : allReserve) {
                    tblpaymentDetails.getItems().add(new PaymentTM(reservationDTO.getRes_id(), reservationDTO.getDate(), reservationDTO.getSid(), reservationDTO.getRoom_typeid(), reservationDTO.getKey_Money(), reservationDTO.getAdvansed(), reservationDTO.getStatus()));
                }
            } catch (SQLException | ClassNotFoundException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            tblpaymentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("res_id"));
            tblpaymentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("student_id"));
            tblpaymentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
            tblpaymentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
            tblpaymentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("key_money"));
            tblpaymentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("advance"));
            tblpaymentDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));
        }*/
    public void BackOnAction(ActionEvent actionEvent) {
    }

   /* public void txtSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (txtsearchid.getText().trim().isEmpty()) {
            //  NotificationController.Warring("Empty Search Id", "Please Enter Current ID.");
            loadAllReserve();
        } else {
            if (RegExit(txtsearchid.getText())) {
                tblpaymentDetails.getItems().clear();
                ArrayList<ReservationDTO> arrayList = reservationBO.getAllReserveSearch(txtsearchid.getText());
                if (arrayList != null) {
                    for (ReservationDTO reservationDTO : arrayList) {
                        tblpaymentDetails.getItems().add(new PaymentTM(reservationDTO.getRes_id(), reservationDTO.getDate(), reservationDTO.getSid(), reservationDTO.getRoom_typeid(), reservationDTO.getKey_Money(), reservationDTO.getAdvansed(), reservationDTO.getStatus()));
                    }
                }
            } else {
                tblpaymentDetails.getItems().clear();
                //  NotificationController.Warring("Empty Data Set", "Please Enter Current ID.");
            }
        }
    }*/


    private boolean RegExit(String id) throws SQLException, ClassNotFoundException {
        return reservationBO.existReserveID(id);
    }

    private void loadAllReserve() {
        tblpaymentDetails.getItems().clear();
        /*Get all Reserve*/
        try {
            ObservableList<PaymentTM> allReserve = reservationBO.getAllReserve();
            tblpaymentDetails.setItems(allReserve);
            /*for (ReservationDTO reservationDTO : allReserve) {
                tblpaymentDetails.getItems().add(new PaymentTM(reservationDTO.getRes_id(), reservationDTO.getDate(), reservationDTO.getSid(), reservationDTO.getRoom_typeid(), reservationDTO.getKey_Money(), reservationDTO.getAdvansed(), reservationDTO.getStatus()));
            }*/
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblpaymentDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("res_id"));
        tblpaymentDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblpaymentDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("student_id"));
        tblpaymentDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        tblpaymentDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("key_money"));
        tblpaymentDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("advance"));
        tblpaymentDetails.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("status"));
        loadAllReserve();
    }

    public void TxtSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (txtsearchid.getText().trim().isEmpty()) {
            //  NotificationController.Warring("Empty Search Id", "Please Enter Current ID.");
            loadAllReserve();
        } else {
            if (RegExit(txtsearchid.getText())) {
                tblpaymentDetails.getItems().clear();
                ArrayList<ReservationDTO> arrayList = reservationBO.getAllReserveSearch(txtsearchid.getText());
                if (arrayList != null) {
                    for (ReservationDTO reservationDTO : arrayList) {
                        tblpaymentDetails.getItems().add(new PaymentTM(reservationDTO.getRes_id(), reservationDTO.getDate(), reservationDTO.getSid(), reservationDTO.getRoom_typeid(), reservationDTO.getKey_Money(), reservationDTO.getAdvansed(), reservationDTO.getStatus()));
                    }
                }
            } else {
                tblpaymentDetails.getItems().clear();
                //  NotificationController.Warring("Empty Data Set", "Please Enter Current ID.");
            }
        }
    }
}
