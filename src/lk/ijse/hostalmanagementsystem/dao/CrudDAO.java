/**
 * @author :Hansaka Malshan
 * created 4/1/2023---12:42 AM
 */
package lk.ijse.hostalmanagementsystem.dao;

public interface CrudDAO <T,Id>extends SuperDAO{
    void save(T dto);

    void update(T dto);

    T search(Id id);

    void delete (Id id);

}
