/**
 * @author :Hansaka Malshan
 * created 3/31/2023---9:53 PM
 */
package lk.ijse.hostalmanagementsystem.utill;

import lk.ijse.hostalmanagementsystem.entity.ReservationEntity;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    public FactoryConfiguration() {
       sessionFactory = (SessionFactory) new Configuration().mergeProperties(Utility.getProperties())
       .addAnnotatedClass(StudentEntity.class)
       .addAnnotatedClass(RoomEntity.class)
       .addAnnotatedClass(ReservationEntity.class)
       .buildSessionFactory();




    }
    public static FactoryConfiguration getinstance(){
        return factoryConfiguration==null ? factoryConfiguration=new FactoryConfiguration() :factoryConfiguration;
    }
    public Session getsession(){
        return sessionFactory.openSession();
    }
}
