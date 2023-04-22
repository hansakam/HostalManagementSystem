/**
 * @author :Hansaka Malshan
 * created 4/20/2023---11:35 PM
 */
package lk.ijse.hostalmanagementsystem.bo.custom.impl;

import lk.ijse.hostalmanagementsystem.bo.custom.UserBO;
import lk.ijse.hostalmanagementsystem.dao.DAOFactory;
import lk.ijse.hostalmanagementsystem.dao.custom.UserDAO;
import lk.ijse.hostalmanagementsystem.dto.UserDTO;
import lk.ijse.hostalmanagementsystem.entity.UserEntity;

import java.sql.SQLException;
import java.util.HashMap;

public class UserBOImpl implements UserBO {

   private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO dto) {
       return userDAO.save(new UserEntity(dto.getUserid(), dto.getUsername(), dto.getPassword(), dto.getEmail()));

    }

    @Override
    public boolean updateUser(UserDTO dto) {
        userDAO.update(new UserEntity(dto.getUserid(),dto.getUsername(), dto.getPassword(), dto.getEmail()));
        return false;
    }

    @Override
    public UserDTO searchUser(String id) throws SQLException, ClassNotFoundException {
        UserEntity entity=userDAO.search(id);
        return new UserDTO(
                entity.getUserid(),entity.getUsername(),entity.getPassword(),entity.getEmail());

    }

    @Override
    public boolean deleteUser(String id) {
        userDAO.delete(id);
        return false;
    }

    @Override
    public boolean UpdatePasswordUser(String id, String password) {
        return userDAO.UpdatePassword(id, password);


    }

    @Override
    public boolean checkPassword(String id, String passwordIdText) {
        HashMap<String,String> alluser=userDAO.getAllUserPassword();
        if(alluser.containsKey(id)){
            return alluser.get(id).equals(passwordIdText);

        }else {

        }
        return false;
    }


}
