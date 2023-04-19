package lk.hostal_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ReservationDTO {
    private String Reservation_ID;
    private String Student_ID;
    private String Room_Type_ID;
    private LocalDate Date;
    private Double Key_Money;
    private String Status;
}
