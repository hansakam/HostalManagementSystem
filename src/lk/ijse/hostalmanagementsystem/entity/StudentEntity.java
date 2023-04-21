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
    @Column
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

    @OneToMany(mappedBy = "sid", fetch = FetchType.EAGER)
    private List<ReservationEntity> studentList = new ArrayList<>();

    public StudentEntity(String student_id, String name, String address, String contact_no, LocalDate dob, String gender) {
        this.sid = student_id;
        this.name = name;
        this.address = address;
        this.contact = contact_no;
        this.dob = dob;
        this.gender = gender;
    }
}
