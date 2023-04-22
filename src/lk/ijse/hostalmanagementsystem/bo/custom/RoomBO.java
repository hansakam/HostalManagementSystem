package lk.ijse.hostalmanagementsystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.tm.RoomTM;

import java.sql.SQLException;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto);
    boolean updateRoom(RoomDTO dto);
    RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException;
    boolean deleteRoom(String id);
    ObservableList<RoomTM> getAllROOm();

}
