/**
 * @author :Hansaka Malshan
 * created 4/20/2023---11:13 PM
 */
package lk.ijse.hostalmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String userid;
    private String username;
    private String password;
    private String email;
}
