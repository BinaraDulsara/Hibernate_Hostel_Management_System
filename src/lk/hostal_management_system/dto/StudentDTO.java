package lk.hostal_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {

    private String StudentID;
    private String Name;
    private String Address;
    private String ContactNumber;
    private LocalDate DateOfBirth;
    private String gender;

}
