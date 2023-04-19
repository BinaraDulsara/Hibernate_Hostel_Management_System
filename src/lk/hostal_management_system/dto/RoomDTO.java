package lk.hostal_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RoomDTO {
    private String RoomTypeID;
    private String Type;
    private String KeyMoney;
    private int RoomQty;
}
