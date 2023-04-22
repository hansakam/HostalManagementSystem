/**
 * @author :Hansaka Malshan
 * created 4/1/2023---7:39 PM
 */
package lk.ijse.hostalmanagementsystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.custom.RoomBO;
import lk.ijse.hostalmanagementsystem.dao.DAOFactory;
import lk.ijse.hostalmanagementsystem.dao.custom.RoomDAO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.tm.RoomTM;

import java.sql.SQLException;
import java.util.List;

public class RoomBOImpl implements RoomBO {

                   /*create daofactorymathod*/

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public boolean saveRoom(RoomDTO dto) {
       roomDAO.save(new RoomEntity(dto.getRid(),dto.getType(),dto.getKeymoney(),dto.getQty()));
        return false;
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        roomDAO.update(new RoomEntity(dto.getRid(),dto.getType(),dto.getKeymoney(),dto.getQty()));

        return false;
    }

    @Override
    public RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException {

        RoomEntity search = roomDAO.search(id);
        return new RoomDTO(search.getRid(),search.getType(),search.getKeymoney(),search.getQty());
    }

    @Override
    public boolean deleteRoom(String id) {
        roomDAO.delete(id);

        return false;
    }

    @Override
    public ObservableList<RoomTM> getAllROOm() {
        List<RoomEntity>roomDAOAll = roomDAO.getAll();
        ObservableList<RoomTM> arraylist = FXCollections.observableArrayList();
        for (RoomEntity dto:roomDAOAll) {

            arraylist.add(new RoomTM(dto.getRid(),dto.getType(),dto.getKeymoney(),dto.getQty()));

        }
        return arraylist;
    }


}
