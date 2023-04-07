package lk.ijse.hostalmanagementsystem.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.hostalmanagementsystem.bo.SuperBO;
import lk.ijse.hostalmanagementsystem.dto.StudentDTO;
import lk.ijse.hostalmanagementsystem.tm.StudentTM;

public interface StudentBO extends SuperBO {
    void saveStudent(StudentDTO dto);
    void updateStudent(StudentDTO dto);
    StudentDTO searchStudent(String id);
    void deleteStudent(String id);
    ObservableList<StudentTM> getAllStudent();


}
