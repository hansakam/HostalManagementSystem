/**
 * @author :Hansaka Malshan
 * created 4/1/2023---12:57 AM
 */
package lk.ijse.hostalmanagementsystem.dao.custom;

import lk.ijse.hostalmanagementsystem.dao.CrudDAO;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;

import java.util.List;

public interface StudentDAO extends CrudDAO<StudentEntity,String> {
     List<StudentEntity> getAll();
}
