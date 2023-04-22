package lk.ijse.hostalmanagementsystem.dao.custom;

import lk.ijse.hostalmanagementsystem.dao.CrudDAO;
import lk.ijse.hostalmanagementsystem.entity.UserEntity;

import java.util.HashMap;

public interface UserDAO extends CrudDAO<UserEntity,String> {
    boolean UpdatePassword(String id,String password);

    HashMap<String, String> getAllUserPassword();
}
