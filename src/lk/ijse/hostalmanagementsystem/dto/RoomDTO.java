/**
 * @author :Hansaka Malshan
 * created 4/1/2023---6:44 PM
 */
package lk.ijse.hostalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private String rid;
    private String type;
    private String keymoney;
    private int qty;

}
