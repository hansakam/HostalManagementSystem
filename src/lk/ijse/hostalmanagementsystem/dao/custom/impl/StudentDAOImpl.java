/**
 * @author :Hansaka Malshan
 * created 4/1/2023---12:55 AM
 */
package lk.ijse.hostalmanagementsystem.dao.custom.impl;

import lk.ijse.hostalmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public void save(StudentEntity entity) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(StudentEntity entity) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

    }

    @Override
    public StudentEntity search(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
       StudentEntity entity= session.get(StudentEntity.class,id);
        System.out.println();
        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        StudentEntity entity = session.get(StudentEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();

    }

    @Override
    public List<StudentEntity> getAll() {
        Session session = FactoryConfiguration.getinstance().getsession();
        String hql="From StudentEntity";
        Query query = session.createQuery(hql);
        List list = query.list();
        session.close();
        return list;
    }
}
