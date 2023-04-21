/**
 * @author :Hansaka Malshan
 * created 4/20/2023---11:09 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity {
    @Id
    private String userid;
    private String username;
    private String address;
    private String email;

}
