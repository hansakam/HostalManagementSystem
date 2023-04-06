/**
 * @author :Hansaka Malshan
 * created 4/2/2023---1:43 AM
 */
package lk.ijse.hostalmanagementsystem.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentTM {
    private String sid;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;
}
