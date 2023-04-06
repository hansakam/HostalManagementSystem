/**
 * @author :Hansaka Malshan
 * created 3/31/2023---10:24 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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



   /* @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<StudentEntity> studentlist=new ArrayList<>();

    public StudentEntity(String sid, String name, String address, String contact, LocalDate dob, String gender) {

    }*/
}
