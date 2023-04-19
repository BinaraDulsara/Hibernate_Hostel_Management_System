package lk.hostal_management_system.view.dtm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RoomTM extends StudentTM {
    String RoomTypeId;
    String Type;
    String KeyMoney;
    int RoomQty;
}
