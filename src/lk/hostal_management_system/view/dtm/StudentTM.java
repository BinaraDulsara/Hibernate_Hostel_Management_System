package lk.hostal_management_system.view.dtm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentTM {

    String StudentId;
    String Name;
    String Address;
    String ContactNumber;
    LocalDate Dob;
    String Gender;

}
