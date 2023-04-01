/**
 * @author :Hansaka Malshan
 * created 4/1/2023---1:27 AM
 */
package lk.ijse.hostalmanagementsystem.dao;

import lk.ijse.hostalmanagementsystem.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.hostalmanagementsystem.dao.custom.impl.ResevationDAOImpl;
import lk.ijse.hostalmanagementsystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostalmanagementsystem.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes{
        STUDENT,ROOM,RESERVATION,PAYMENT
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ResevationDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            default:
                return null;
        }
    }
}
