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
        studentDAO.update(new StudentEntity(dto.getSid(),dto.getName(),dto.getAddress(),dto.getContact(),dto.getDob(),dto.getGender()));

    }

    @Override
    public Studentdto searchStudent(String id) {
        StudentEntity  entity=studentDAO.search(id);
        return new Studentdto(
       entity.getSid(),entity.getName(),entity.getAddress(),entity.getContact(),entity.getDob(),entity.getGender());

    }

    @Override
    public void deleteStudent(String id) {
        studentDAO.delete(id);

    }
}
