package lk.ijse.hostalmanagementsystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;

import java.sql.SQLException;

public interface StudentBO extends SuperBO {
    boolean saveStudent(StudentDTO dto);
    boolean updateStudent(StudentDTO dto);
    StudentDTO searchStudent(String id) throws SQLException, ClassNotFoundException;
    boolean deleteStudent(String id);
    ObservableList<StudentTM> getAllStudent();


}
