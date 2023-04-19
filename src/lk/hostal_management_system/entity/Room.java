package lk.hostal_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room implements SuperEntity {
    @Id
    private String RoomTypeID;
    private String Type;
    private String KeyMoney;
    private int RoomQty;
    @OneToMany(mappedBy = "room")
    List<Reservation> roomDetails=new ArrayList<>();

    public Room(String roomTypeID, String type, String keyMoney, int roomQty) {
        RoomTypeID = roomTypeID;
        Type = type;
        KeyMoney = keyMoney;
        RoomQty = roomQty;
    }
}
