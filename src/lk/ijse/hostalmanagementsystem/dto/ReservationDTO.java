/**
 * @author :Hansaka Malshan
 * created 4/1/2023---10:08 PM
 */
package lk.ijse.hostalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDTO {
    private String resid;
    private LocalDate date;
    private String sid;
    private String roomtypeid;
    private String status;

}

