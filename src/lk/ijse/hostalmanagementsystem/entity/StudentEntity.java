/**
 * @author :Hansaka Malshan
 * created 3/31/2023---10:24 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class StudentEntity {
    @Id
    private String sid;
    private String name;
    private String address;
    private String contact;
    private int dob;
    private String gender;

}
