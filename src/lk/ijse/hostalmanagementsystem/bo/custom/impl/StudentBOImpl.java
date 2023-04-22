/**
 * @author :Hansaka Malshan
 * created 4/1/2023---1:46 AM
 */
package lk.ijse.hostalmanagementsystem.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.custom.StudentBO;
import lk.ijse.hostalmanagementsystem.dao.DAOFactory;
import lk.ijse.hostalmanagementsystem.dao.custom.StudentDAO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;

import java.sql.SQLException;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);



    @Override
    public boolean saveStudent(StudentDTO dto) {
        studentDAO.save(new StudentEntity(dto.getSid(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        studentDAO.update(new StudentEntity(dto.getSid(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));

        return false;
    }

    @Override
    public StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException {
        StudentEntity  entity=studentDAO.search(id);
        return new StudentDTO(
       entity.getSid(),entity.getName(),entity.getAddress(),entity.getContact(),entity.getDob(),entity.getGender());

    }

    @Override
    public boolean deleteStudent(String id) {
        studentDAO.delete(id);

        return false;
    }

    @Override
    public ObservableList<StudentTM> getAllStudent() {
        List<StudentEntity> studentDAOAll = studentDAO.getAll();
        ObservableList<StudentTM> arrayList = FXCollections.observableArrayList();
        for (StudentEntity dto:studentDAOAll) {

                arrayList.add(new StudentTM(dto.getSid(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
        }
        return arrayList;
    }
}
