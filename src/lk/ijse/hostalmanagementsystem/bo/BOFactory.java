/**
 * @author :Hansaka Malshan
 * created 4/1/2023---1:37 AM
 */
package lk.ijse.hostalmanagementsystem.bo;

import lk.ijse.hostalmanagementsystem.bo.custom.impl.PaymentBOImpl;
import lk.ijse.hostalmanagementsystem.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostalmanagementsystem.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostalmanagementsystem.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    public enum BOTypes{
        STUDENT,ROOM,RESERVATION,PAYMENT
    }
    public SuperBO getBO(BOTypes types){
      switch (types){
          case STUDENT:
              return new StudentBOImpl();
          case ROOM:
              return new RoomBOImpl();
          case PAYMENT:
              return new PaymentBOImpl();
          case RESERVATION:
              return new ReservationBOImpl();
          default:
              return null;
      }

    }
}
