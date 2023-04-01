/**
 * @author :Hansaka Malshan
 * created 4/1/2023---7:39 PM
 */
package lk.ijse.hostalmanagementsystem.bo.custom.impl;

import lk.ijse.hostalmanagementsystem.bo.custom.RoomBO;
import lk.ijse.hostalmanagementsystem.dao.DAOFactory;
import lk.ijse.hostalmanagementsystem.dao.custom.RoomDAO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;

public class RoomBOImpl implements RoomBO {

                   /*create daofactorymathod*/

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public void saveRoom(RoomDTO dto) {
       roomDAO.save(new RoomEntity(dto.getRid(),dto.getType(),dto.getKeymoney(),dto.getQty()));
    }

    @Override
    public void updateRoom(RoomDTO dto) {
        roomDAO.update(new RoomEntity(dto.getRid(),dto.getType(),dto.getKeymoney(),dto.getQty()));

    }

    @Override
    public RoomDTO searchRoom(String id) {

        RoomEntity search = roomDAO.search(id);
        return new RoomDTO(search.getRid(),search.getType(),search.getKeymoney(),search.getQty());
    }

    @Override
    public void deleteRoom(String id) {
        roomDAO.delete(id);

    }
}
