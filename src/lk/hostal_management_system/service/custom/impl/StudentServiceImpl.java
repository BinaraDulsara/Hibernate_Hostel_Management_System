package lk.hostal_management_system.service.custom.impl;

import lk.hostal_management_system.dao.DAOFactory;
import lk.hostal_management_system.dao.custom.StudentDAO;
import lk.hostal_management_system.dto.StudentDTO;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.service.SuperService;
import lk.hostal_management_system.service.custom.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO= (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDTO> getAllStudentDetails() throws IOException {
        List<Student> all = studentDAO.findAll();
        List<StudentDTO> getStudentsDetails=new ArrayList<>();
        for (Student student:all){
            getStudentsDetails.add(new StudentDTO(
                    student.getStudentID(),
                    student.getName(),
                    student.getAddress(),
                    student.getContactNumber(),
                    student.getDateOfBirth(),
                    student.getGender()
            ));
        }
        return getStudentsDetails;
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) throws IOException {
        return studentDAO.save(new Student(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContactNumber(),
                studentDTO.getDateOfBirth(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean UpdateStudent(StudentDTO studentDTO) throws IOException {
        return studentDAO.update(new Student(
                studentDTO.getStudentID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContactNumber(),
                studentDTO.getDateOfBirth(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean DeleteStudent(String id) throws IOException {
        return studentDAO.deleteByPK(id);

    }
}
