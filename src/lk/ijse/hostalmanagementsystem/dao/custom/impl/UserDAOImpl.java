/**
 * @author :Hansaka Malshan
 * created 4/20/2023---11:18 PM
 */
package lk.ijse.hostalmanagementsystem.dao.custom.impl;

import lk.ijse.hostalmanagementsystem.dao.custom.UserDAO;
import lk.ijse.hostalmanagementsystem.entity.UserEntity;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(UserEntity dto) {
        return false;
    }

    @Override
    public boolean update(UserEntity dto) {
        return false;
    }

    @Override
    public UserEntity search(String s) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
