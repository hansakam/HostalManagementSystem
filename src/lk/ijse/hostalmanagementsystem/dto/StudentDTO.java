/**
 * @author :Hansaka Malshan
 * created 3/31/2023---10:31 PM
 */
package lk.ijse.hostalmanagementsystem.dto;

import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String sid;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;

}
