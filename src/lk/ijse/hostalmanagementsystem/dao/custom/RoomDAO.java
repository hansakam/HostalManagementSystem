package lk.ijse.hostalmanagementsystem.dao.custom;

import lk.ijse.hostalmanagementsystem.dao.CrudDAO;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RoomDAO extends CrudDAO<RoomEntity,String> {
    ArrayList<RoomEntity> getAll();
     boolean exist(String id) throws SQLException, ClassNotFoundException;

}
