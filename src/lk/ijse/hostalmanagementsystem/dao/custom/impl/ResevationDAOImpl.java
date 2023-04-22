/**
 * @author :Hansaka Malshan
 * created 4/1/2023---11:44 PM
 */
package lk.ijse.hostalmanagementsystem.dao.custom.impl;

import lk.ijse.hostalmanagementsystem.dao.custom.ReservationDAO;
import lk.ijse.hostalmanagementsystem.entity.ReservationEntity;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResevationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(ReservationEntity entity) {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ReservationEntity entity) {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ReservationEntity search(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        ReservationEntity room = session.get(ReservationEntity.class, id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean delete(String id) {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        ReservationEntity reservation = session.get(ReservationEntity.class, id);
        session.delete(reservation);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        List<String> list = session.createQuery("SELECT resid FROM ReservationEntity ORDER BY resid DESC ").setMaxResults(1).list();
        transaction.commit();
        session.close();
        return list.size()>0? String.format("#R%03d",Integer.parseInt(list.get(0).replace("#R",""))+1):"#R001";
    }

    public List<ReservationEntity> getAll() throws SQLException, ClassNotFoundException {


        Session session = FactoryConfiguration.getinstance().getsession();
       // Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From ReservationEntity ");
        List<ReservationEntity> list = query.list();
        //transaction.commit();
        session.close();
        return list;
    }
    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT resid FROM ReservationEntity WHERE resid=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1 != null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

}
