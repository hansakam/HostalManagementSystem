package lk.ijse.hostalmanagementsystem.bo.custom;

import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dao.CrudDAO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;

public interface RoomBO extends SuperBO {
    void saveRoom(RoomDTO dto);
    void updateRoom(RoomDTO dto);
    RoomDTO searchRoom(String id);
    void deleteRoom(String id);
}
