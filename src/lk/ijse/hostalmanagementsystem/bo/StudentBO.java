package lk.ijse.hostalmanagementsystem.bo;

import lk.ijse.hostalmanagementsystem.dto.Studentdto;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;

public interface StudentBO extends SuperBO{
    void saveStudent(Studentdto dto);
    void updateStudent(Studentdto dto);
    Studentdto searchStudent(String id);
    void deleteStudent(String id);


}
