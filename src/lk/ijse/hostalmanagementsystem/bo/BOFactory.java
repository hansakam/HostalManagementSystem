/**
 * @author :Hansaka Malshan
 * created 4/1/2023---1:37 AM
 */
package lk.ijse.hostalmanagementsystem.bo;

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
        STUDENT,ROOM
    }
    public SuperBO getBO(BOTypes types){
      switch (types){
          case STUDENT:
              return new StudentBOImpl();
          case ROOM:
              return new RoomBOImpl();

          default:
              return null;
      }

    }
}
