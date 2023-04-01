/**
 * @author :Hansaka Malshan
 * created 4/1/2023---10:12 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

  /*  @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="sid",referencedColumnName = "sid")
    private ReservationEntity studententity;



    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "res_id",referencedColumnName = "res_id")
    private RoomEntity roomEntity;
*/
}
