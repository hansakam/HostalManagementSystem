/**
 * @author :Hansaka Malshan
 * created 4/1/2023---6:59 PM
 */
package lk.ijse.hostalmanagementsystem.dao.custom.impl;

import lk.ijse.hostalmanagementsystem.dao.custom.RoomDAO;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(RoomEntity entity) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(RoomEntity entity) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public RoomEntity search(String id) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        RoomEntity entity = session.get(RoomEntity.class, id);
        transaction.commit();
        session.close();
        return entity;

    }

    @Override
    public boolean delete(String id) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        RoomEntity roomEntity = session.get(RoomEntity.class, id);
        session.delete(roomEntity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<RoomEntity> getAll() {
        ArrayList<RoomEntity> allRoom;
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM RoomEntity ");
        allRoom = (ArrayList<RoomEntity>) query.list();
        transaction.commit();
        session.close();
        return allRoom;
    }

    @Override
   /* public List<RoomEntity> getAll() {
        Session session = FactoryConfiguration.getinstance().getsession();
        String hql="From RoomEntity";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }*/
    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT rid FROM RoomEntity WHERE rid=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1 != null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }



}
