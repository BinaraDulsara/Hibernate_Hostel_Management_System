package lk.hostal_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reservation implements SuperEntity{
    @Id
    private String Reservation_ID;
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;
    @Column(columnDefinition = "DATE")
    private LocalDate Date;
    private Double Key_Money;
    private String Status;

}
