/**
 * @author :Hansaka Malshan
 * created 4/1/2023---6:59 PM
 */
package lk.ijse.hostalmanagementsystem.dao;

import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoomDAOImpl implements RoomDAO{
    @Override
    public void save(RoomEntity entity) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(RoomEntity entity) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
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
    public void delete(String id) {
        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        RoomEntity roomEntity = session.get(RoomEntity.class, id);
        session.delete(roomEntity);
        transaction.commit();
        session.close();

    }
}
