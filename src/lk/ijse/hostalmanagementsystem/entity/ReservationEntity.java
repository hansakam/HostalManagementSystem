/**
 * @author :Hansaka Malshan
 * created 4/1/2023---10:12 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ReservationEntity {
    @Id
    @Column(name ="res_id")
    private String resid;
    private LocalDate date;
    @Column(name ="student_id")
    private String sid;
    @Column(name ="room_type_id")
    private String roomtypeid;
    private String status;

}
