package lk.hostal_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.hostal_management_system.dto.StudentDTO;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.service.ServiceFactroy;
import lk.hostal_management_system.service.custom.StudentService;
import lk.hostal_management_system.view.dtm.StudentTM;

import javax.persistence.Id;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class StudentController {
    public JFXTextField txtStudentId;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNumber;
    public JFXTextField txtDateOfBirth;
    public JFXTextField txtGender;
    public TableView<StudentTM> tblStudent;
    public TableColumn tblStudentId;
    public TableColumn tblName;
    public TableColumn tblAddress;
    public TableColumn tblContactNumber;
    public TableColumn tblDateOfBirth;
    public TableColumn tblGender;
    public JFXButton btnadd;
    public JFXButton btnDelete;
    public JFXButton btnEdit;
    public JFXComboBox<String> cmbGender;
    public JFXDatePicker dob;
    public JFXDatePicker cmbDOB;

    StudentService studentService = (StudentService) ServiceFactroy.getBoFactory().getBO(ServiceFactroy.BOTypes.STUDENT);


    public void initialize() throws IOException {

        cmbGender.getItems().addAll("Male","Female");

        tblStudentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        tblContactNumber.setCellValueFactory(new PropertyValueFactory<>("ContactNumber"));
        tblDateOfBirth.setCellValueFactory(new PropertyValueFactory<>("dob"));
        tblGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));

                loadStudentDetails();
    }

    private void loadStudentDetails() throws IOException {
        tblStudent.getItems().clear();
        List<StudentDTO> studentDetails = studentService.getAllStudentDetails();
        for (StudentDTO student:studentDetails){
            tblStudent.getItems().add(new StudentTM(
                    student.getStudentID(),
                    student.getName(),
                    student.getAddress(),
                    student.getContactNumber(),
                    student.getDateOfBirth(),
                    student.getGender()));
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtStudentId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String number = txtContactNumber.getText();
        LocalDate dob = cmbDOB.getValue();
        String gender = cmbGender.getValue();


        if (id.isEmpty() || !id.matches("^(S)([0-9]{3})$")) {

            new Alert(Alert.AlertType.ERROR, "Student Id Invalid or empty").show();

            txtStudentId.selectAll();
            txtStudentId.requestFocus();
            return;

        } else if (name.isEmpty() || !name.matches("[A-Za-z]+")) {

            new Alert(Alert.AlertType.ERROR, "Student Name Invalid or empty").show();
            txtName.selectAll();
            txtName.requestFocus();

            return;

        } else if (address.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Address Invalid or empty").show();
            txtAddress.selectAll();
            txtAddress.requestFocus();
            return;

        } else if (number.isEmpty() || !number.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
            new Alert(Alert.AlertType.ERROR, "Student Contact Number Invalid or empty").show();
            txtContactNumber.selectAll();
            txtContactNumber.requestFocus();
            return;

        }
        if (studentService.addStudent(new StudentDTO(id, name, address, number, dob, gender))) {
            new Alert(Alert.AlertType.CONFIRMATION,"Student added!").show();
            loadStudentDetails();
            ClearMethod();
        }
    }

    private void ClearMethod() {
        txtStudentId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContactNumber.clear();
        cmbDOB.setValue(null);
        cmbGender.setValue(null);
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtStudentId.getText();

        try {
            boolean isDeleted = studentService.DeleteStudent(id);
            tblStudent.refresh();
            loadStudentDetails();
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Student deleted..!");
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong..!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnEditOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtStudentId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String number = txtContactNumber.getText();
        LocalDate dob = cmbDOB.getValue();
        String gender =cmbGender.getValue();


        if (id.isEmpty() || !id.matches("^(S)([0-9]{3})$")) {

            new Alert(Alert.AlertType.ERROR, "Student Id Invalid or empty").show();

            txtStudentId.selectAll();
            txtStudentId.requestFocus();
            return;

        } else if (name.isEmpty() || !name.matches("[A-Za-z]+")) {

            new Alert(Alert.AlertType.ERROR, "Student Name Invalid or empty").show();
            txtName.selectAll();
            txtName.requestFocus();

            return;

        } else if (address.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Student Address Invalid or empty").show();
            txtAddress.selectAll();
            txtAddress.requestFocus();
            return;

        } else if (number.isEmpty() || !number.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
            new Alert(Alert.AlertType.ERROR, "Student Contact Number Invalid or empty").show();
            txtContactNumber.selectAll();
            txtContactNumber.requestFocus();
            return;

        }

        if (studentService.UpdateStudent(new StudentDTO(id,name,address,number,dob,gender))){
            loadStudentDetails();
            ClearMethod();
        }
    }


    public void tblStudentOnMouseClicked(MouseEvent mouseEvent) {
        StudentTM selectedItem = tblStudent.getSelectionModel().getSelectedItem();
            if (selectedItem!=null){
                txtStudentId.setText(selectedItem.getStudentId());
                txtName.setText(selectedItem.getName());
                txtAddress.setText(selectedItem.getAddress());
                txtContactNumber.setText(selectedItem.getContactNumber());
                cmbDOB.setValue(selectedItem.getDob());
                cmbGender.setValue(selectedItem.getGender());
            }
    }
}

