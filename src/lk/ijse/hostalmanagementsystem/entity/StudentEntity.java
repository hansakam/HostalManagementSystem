/**
 * @author :Hansaka Malshan
 * created 3/31/2023---10:24 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StudentEntity {
    @Id
    private String sid;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;


}
