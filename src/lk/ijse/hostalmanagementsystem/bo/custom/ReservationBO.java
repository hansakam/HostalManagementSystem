package lk.ijse.hostalmanagementsystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.tm.PaymentTM;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    String generateNewReserveID() throws SQLException, ClassNotFoundException;
     boolean PurchaseRoom(ReservationDTO dto) throws SQLException, ClassNotFoundException;
    boolean checkRoomIsAvailable(String code) throws SQLException, ClassNotFoundException;
     boolean checkStudentIsAvailable(String id) throws SQLException, ClassNotFoundException;
     StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException;
    RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException;
     ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;
    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;
    ObservableList<PaymentTM> getAllReserve() throws SQLException, ClassNotFoundException;
    boolean existReserveID(String id) throws SQLException, ClassNotFoundException;
    ArrayList<ReservationDTO> getAllReserveSearch(String id) throws SQLException, ClassNotFoundException;
}
