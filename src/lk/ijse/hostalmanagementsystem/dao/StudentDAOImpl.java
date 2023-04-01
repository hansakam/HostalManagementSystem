/**
 * @author :Hansaka Malshan
 * created 4/1/2023---12:55 AM
 */
package lk.ijse.hostalmanagementsystem.dao;

import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO{
    @Override
    public void save(StudentEntity entity) {

        Session session = new FactoryConfiguration().getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(StudentEntity dto) {

    }

    @Override
    public StudentEntity search(String s) {
        return null;
    }

    @Override
    public void delete(String delete) {

    }
}
