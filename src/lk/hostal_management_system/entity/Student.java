package lk.hostal_management_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student implements SuperEntity {
    @Id
    private String StudentID;
    private String Name;
    private String Address;
    private String ContactNumber;
    @Column(columnDefinition = "DATE")
    private LocalDate DateOfBirth;
    private String Gender;

    @OneToMany(mappedBy = "student")
    List<Reservation> reservations=new ArrayList<>();

    public Student(String studentID, String name, String address, String contactNumber, LocalDate dateOfBirth, String gender) {
        StudentID = studentID;
        Name = name;
        Address = address;
        ContactNumber = contactNumber;
        DateOfBirth = dateOfBirth;
        Gender = gender;
    }
}
