/**
 * @author :Hansaka Malshan
 * created 4/1/2023---10:08 PM
 */
package lk.ijse.hostalmanagementsystem.dto;

import lk.ijse.hostalmanagementsystem.entity.RoomEntity;
import lk.ijse.hostalmanagementsystem.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String res_id;
    private LocalDate date;
    private String sid;
    private String room_typeid;
    private String status;
    private String Key_Money;
    private double advansed;



}

