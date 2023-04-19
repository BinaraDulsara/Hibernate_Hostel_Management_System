package lk.hostal_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PlaceOrderController {
    public TableView tblPlaceOrder;
    public TableColumn tblReservationId;
    public TableColumn tblStudentId;
    public TableColumn tblRoomTypeId;
    public TableColumn tblDate;
    public TableColumn tblKeyMoney;
    public TableColumn tblStatus;
    public JFXButton btnAdd;
    public JFXButton btnEdit;
    public JFXButton btnDelete;
    public AnchorPane anchorPanePlaceOrder;
    public JFXTextField txtStatus;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtDate;
    public JFXTextField txtReservationId;
    public JFXComboBox cmbStudentId;
    public JFXComboBox cmbRoomTypeId;
    public Pane panePlaceOrder;


    public void btnDeleteOnActive(ActionEvent actionEvent) {
    }

    public void btnAddOnActive(ActionEvent actionEvent) {
    }

    public void btnEditOnAction(ActionEvent actionEvent) {
    }
}
