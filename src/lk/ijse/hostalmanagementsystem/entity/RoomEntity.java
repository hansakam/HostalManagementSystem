/**
 * @author :Hansaka Malshan
 * created 4/1/2023---6:49 PM
 */
package lk.ijse.hostalmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RoomEntity {
    @Id
    private String rid;
    @Column
    private String type;
    private String keymoney;
    private int qty;

    @OneToMany(mappedBy = "roomtypeid", fetch = FetchType.EAGER)
    private List<ReservationEntity> roomDetails = new ArrayList<>();

    public RoomEntity(String room_type_id, String type, String key_money, int qty) {
        this.rid = room_type_id;
        this.type = type;
        this.keymoney = key_money;
        this.qty = qty;
    }
}
