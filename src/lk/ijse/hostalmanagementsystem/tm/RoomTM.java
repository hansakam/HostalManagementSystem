/**
 * @author :Hansaka Malshan
 * created 4/2/2023---1:43 AM
 */
package lk.ijse.hostalmanagementsystem.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomTM {
    private String rid;
    private String type;
    private String keymoney;
    private int qty;
}
