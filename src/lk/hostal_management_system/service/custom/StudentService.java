package lk.hostal_management_system.service.custom;

import lk.hostal_management_system.dto.StudentDTO;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface StudentService extends SuperService {


    List<StudentDTO> getAllStudentDetails() throws IOException;

    boolean addStudent(StudentDTO studentDTO) throws IOException;

    boolean UpdateStudent(StudentDTO studentDTO) throws IOException;

    boolean DeleteStudent(String id) throws IOException;

}
