/**
 * @author :Hansaka Malshan
 * created 4/2/2023---12:00 AM
 */
package lk.ijse.hostalmanagementsystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.custom.ReservationBO;
import lk.ijse.hostalmanagementsystem.dao.DAOFactory;
import lk.ijse.hostalmanagementsystem.dao.SuperDAO;
import lk.ijse.hostalmanagementsystem.dao.custom.ReservationDAO;
import lk.ijse.hostalmanagementsystem.dao.custom.RoomDAO;
import lk.ijse.hostalmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.hostalmanagementsystem.dto.ReservationDTO;
import lk.ijse.hostalmanagementsystem.dto.RoomDTO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.entity.ReservationEntity;
import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import lk.ijse.hostalmanagementsystem.tm.PaymentTM;
import lk.ijse.hostalmanagementsystem.tm.RoomTM;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;
import lk.ijse.hostalmanagementsystem.utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReservationDAO reservedao = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);


    @Override
    public String generateNewReserveID() throws SQLException, ClassNotFoundException {
        return reservedao.generateNewId();
    }

    public boolean PurchaseRoom(ReservationDTO dto) throws SQLException, ClassNotFoundException {


        Session session = FactoryConfiguration.getinstance().getsession();
        Transaction transaction = session.beginTransaction();
        StudentEntity student = session.get(StudentEntity.class, dto.getSid());
        RoomEntity room = session.get(RoomEntity.class, dto.getRoom_typeid());

        ReservationEntity reserve = new ReservationEntity(dto.getRes_id(), dto.getDate(), student, room, dto.getKey_Money(), dto.getStatus(), dto.getAdvansed());
        session.save(reserve);

        room.setQty(room.getQty() - 1);
        session.update(room);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean checkRoomIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return roomDAO.exist(code);
    }


    public boolean checkStudentIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.exist(id);
    }


    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException {
        StudentEntity ent = studentDAO.search(id);
        return new StudentDTO(ent.getSid(), ent.getName(), ent.getAddress(), ent.getContact(), ent.getDob(), ent.getGender());
    }


    public RoomDTO searchRoom(String id) throws SQLException, ClassNotFoundException {
        RoomEntity ent = roomDAO.search(id);
        return new RoomDTO(ent.getRid(), ent.getType(), ent.getKeymoney(), ent.getQty());
    }

    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<StudentEntity> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();
        for (StudentEntity student : all) {
            allStudent.add(new StudentDTO(student.getSid(), student.getName(), student.getAddress(), student.getContact(), student.getDob(), student.getGender()));
        }
        return allStudent;
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        ArrayList<RoomEntity> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();
        for (RoomEntity room : all) {
            allRoom.add(new RoomDTO(room.getRid(), room.getType(), room.getKeymoney(), room.getQty()));
        }
        return allRoom;
    }

   /* @Override
    public ArrayList<ReservationDTO> getAllReserve() throws SQLException, ClassNotFoundException {
        return null;
    }*/


    public ObservableList<PaymentTM> getAllReserve() throws SQLException, ClassNotFoundException {
        List<ReservationEntity> all = reservedao.getAll();
       /* ArrayList<ReservationDTO> allReserve = new ArrayList<>();*/
        ObservableList<PaymentTM> tblall= FXCollections.observableArrayList();
        for (ReservationEntity entity:all) {

            tblall.add(new PaymentTM(entity.getResid(),entity.getDate(),entity.getSid().getSid(),entity.getRoomtypeid().getRid(),entity.getKey_Money(),entity.getAdvanse(),entity.getStatus()));
        }
        return tblall;
    }
    public boolean existReserveID(String id) throws SQLException, ClassNotFoundException {
        return reservedao.exist(id);
    }
    public ArrayList<ReservationDTO> getAllReserveSearch(String id) throws SQLException, ClassNotFoundException {
        ReservationEntity all = reservedao.search(id);
        ArrayList<ReservationDTO> allSearchReserve = new ArrayList<>();
        allSearchReserve.add(new ReservationDTO(all.getResid(), all.getDate(), all.getSid().getSid(), all.getRoomtypeid().getRid(), all.getKey_Money(), all.getStatus(),all.getAdvanse()));
        return allSearchReserve;
    }
}
