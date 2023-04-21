/**
 * @author :Hansaka Malshan
 * created 4/1/2023---12:42 AM
 */
package lk.ijse.hostalmanagementsystem.dao;

import java.sql.SQLException;

public interface CrudDAO <T,Id>extends SuperDAO{
    boolean save(T dto);

    boolean update(T dto);

    T search(Id id) throws SQLException, ClassNotFoundException;

    boolean delete (Id id);

}
