/**
 * @author :Hansaka Malshan
 * created 4/1/2023---1:46 AM
 */
package lk.ijse.hostalmanagementsystem.bo;

import lk.ijse.hostalmanagementsystem.dao.DAOFactory;
import lk.ijse.hostalmanagementsystem.dao.StudentDAO;
import lk.ijse.hostalmanagementsystem.dao.SuperDAO;
import lk.ijse.hostalmanagementsystem.dto.Studentdto;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;

public class StudentBOImpl implements StudentBO{

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);



    @Override
    public void saveStudent(Studentdto dto) {
        studentDAO.save(new StudentEntity(dto.getSid(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));
    }

    @Override
    public void updateStudent(Studentdto dto) {

    }

    @Override
    public Studentdto searchStudent(String id) {
        return null;
    }

    @Override
    public void deleteStudent(String id) {

    }
}
