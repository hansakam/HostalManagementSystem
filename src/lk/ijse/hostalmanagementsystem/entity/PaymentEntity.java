/**
 * @author :Hansaka Malshan
 * created 4/21/2023---8:17 PM
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
public class PaymentEntity {
    @Id
    private String pid;


}
