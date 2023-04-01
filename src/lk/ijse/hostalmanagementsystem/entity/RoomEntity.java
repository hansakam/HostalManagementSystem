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
    @Column(name = "room_type_Id")
    private String rid;
    private String type;
    @Column(name = "key_money")
    private String keymoney;
    private int qty;


/*
    @OneToMany
    private List<ReservationEntity>resarvationlist=new ArrayList<>();*/
}
