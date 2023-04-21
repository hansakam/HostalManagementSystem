/**
 * @author :Hansaka Malshan
 * created 4/19/2023---11:46 PM
 */
package lk.ijse.hostalmanagementsystem.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTM {

    private String res_id;
    private LocalDate date;
    private String student_id;
    private String room_type_id;
    private String key_money;
    private Double advance;
    private String status;
}
