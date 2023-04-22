/**
 * @author :Hansaka Malshan
 * created 4/20/2023---11:18 PM
 */
package lk.ijse.hostalmanagementsystem.dao.custom.impl;

import lk.ijse.hostalmanagementsystem.dao.custom.UserDAO;
import lk.ijse.hostalmanagementsystem.entity.UserEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(UserEntity dto) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(UserEntity dto) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public UserEntity search(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        UserEntity entity= session.get(UserEntity.class,id);
        System.out.println();
        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        UserEntity entity = session.get(UserEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();

        return true;
    }

    public boolean UpdatePassword(String id,String password){
        String check="UPDATE UserEntity SET password = : newpassword WHERE userid =:newuser";
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(check);
        query.setParameter("newpassword",password);
        query.setParameter("newuser",id);
        int update = query.executeUpdate();
        transaction.commit();
        session.close();
        if(0<update){
            return true;
        }
        return false;
    }

    @Override
    public HashMap<String, String> getAllUserPassword() {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        List<Object[]> list = session.createQuery("SELECT userid , password FROM UserEntity ").list();
        transaction.commit();
        session.close();
        HashMap<String,String> userMap = new HashMap<>();
        list.stream().forEach(o -> userMap.put((String)o[0],(String) o[1]));
        return userMap;
    }
}
