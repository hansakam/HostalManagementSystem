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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(StudentEntity entity) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(StudentEntity entity) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

        return true;
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
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        StudentEntity entity = session.get(StudentEntity.class, id);
        session.delete(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<StudentEntity> getAll() {
        ArrayList<StudentEntity> allStudents;
        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM StudentEntity ");
        allStudents = (ArrayList<StudentEntity>) query.list();
        transaction.commit();
        session.close();
        return allStudents;
    }

    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT sid FROM StudentEntity WHERE sid=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1 != null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }
}
