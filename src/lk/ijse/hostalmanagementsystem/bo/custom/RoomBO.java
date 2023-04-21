package lk.ijse.hostalmanagementsystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dao.CrudDAO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.tm.RoomTM;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;

import java.sql.SQLException;

public interface RoomBO extends SuperBO {
    void saveRoom(RoomDTO dto);
    void updateRoom(RoomDTO dto);
    RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException;
    void deleteRoom(String id);
    ObservableList<RoomTM> getAllROOm();

}
