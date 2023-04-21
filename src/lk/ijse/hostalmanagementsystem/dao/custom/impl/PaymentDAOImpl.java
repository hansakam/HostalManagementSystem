/**
 * @author :Hansaka Malshan
 * created 4/1/2023---11:55 PM
 */
package lk.ijse.hostalmanagementsystem.dao.custom.impl;

import lk.ijse.hostalmanagementsystem.dao.custom.PaymentDAO;
import lk.ijse.hostalmanagementsystem.entity.PaymentEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(PaymentEntity entity) {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(PaymentEntity entity) {


        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public PaymentEntity search(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        PaymentEntity reservation = session.get(PaymentEntity.class, id);
        transaction.commit();
        session.close();
        return reservation;
    }

    @Override
    public boolean delete(String id) {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        PaymentEntity reservation = session.get(PaymentEntity.class, id);
        session.delete(reservation);
        transaction.commit();
        session.close();
        return true;
    }
}
