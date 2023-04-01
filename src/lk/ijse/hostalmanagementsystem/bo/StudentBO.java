package lk.ijse.hostalmanagementsystem.bo;

import lk.ijse.hostalmanagementsystem.dto.StudentDTO;

public interface StudentBO extends SuperBO{
    void saveStudent(StudentDTO dto);
    void updateStudent(StudentDTO dto);
    StudentDTO searchStudent(String id);
    void deleteStudent(String id);


}
