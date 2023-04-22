package lk.ijse.hostalmanagementsystem.bo.custom;

import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dto.UserDTO;

import java.sql.SQLException;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO dto);
    boolean updateUser(UserDTO dto);
    UserDTO searchUser(String id) throws SQLException, ClassNotFoundException;
    boolean deleteUser(String id);
    boolean UpdatePasswordUser(String id,String password);

    boolean checkPassword(String text, String passwordIdText);
}
