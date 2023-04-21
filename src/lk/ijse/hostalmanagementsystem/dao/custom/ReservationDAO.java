package lk.ijse.hostalmanagementsystem.dao.custom;

import lk.ijse.hostalmanagementsystem.dao.CrudDAO;
import lk.ijse.hostalmanagementsystem.dao.SuperDAO;
import lk.ijse.hostalmanagementsystem.entity.ReservationEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ReservationDAO extends CrudDAO<ReservationEntity,String> {
    String generateNewId() throws SQLException, ClassNotFoundException;
     List<ReservationEntity> getAll() throws SQLException, ClassNotFoundException;
    boolean exist(String id) throws SQLException, ClassNotFoundException;
    ReservationEntity search(String id) throws SQLException, ClassNotFoundException;

}
