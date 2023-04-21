/**
 * @author :Hansaka Malshan
 * created 4/1/2023---10:12 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReservationEntity {
    @Id
    private String resid;
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_Id", referencedColumnName = "sid")
    private StudentEntity sid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id", referencedColumnName = "rid")
    private RoomEntity roomtypeid;

    private String status;

    private String Key_Money;
    private double advanse;
}
