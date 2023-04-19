package lk.hostal_management_system.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.hostal_management_system.dto.RoomDTO;
import lk.hostal_management_system.dto.StudentDTO;
import lk.hostal_management_system.service.ServiceFactroy;
import lk.hostal_management_system.service.custom.RoomService;
import lk.hostal_management_system.service.custom.StudentService;
import lk.hostal_management_system.view.dtm.RoomTM;
import lk.hostal_management_system.view.dtm.StudentTM;

import java.io.IOException;
import java.util.List;

public class RoomController {
    public AnchorPane roomAnchorPane;
    public TableView <RoomTM>tblRoom;
    public TableColumn tblRoomTypeId;
    public TableColumn tblType;
    public TableColumn tblKeyMoney;
    public TableColumn tblRoomQty;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXButton btnAdd;
    public JFXButton btnEdit;
    public JFXButton btnDelete;

    RoomService roomService =(RoomService) ServiceFactroy.getBoFactory().getBO(ServiceFactroy.BOTypes.ROOM);

    public void initialize() throws IOException {

        tblRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("RoomTypeId"));
        tblType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tblKeyMoney.setCellValueFactory(new PropertyValueFactory<>("KeyMoney"));
        tblRoomQty.setCellValueFactory(new PropertyValueFactory<>("RoomQty"));

        loadRoomDetails();
    }
    private void loadRoomDetails() throws IOException {
        tblRoom.getItems().clear();
         List<RoomDTO>roomDetails  = roomService.getAllRoomDetails();
         for (RoomDTO room:roomDetails){
             tblRoom.getItems().add(new RoomTM(
                room.getRoomTypeID(),
                room.getType(),
                room.getKeyMoney(),
                room.getRoomQty()));
         }
    }

    public void btnAddOnAction(ActionEvent actionEvent) throws IOException {
        String RoomTypeId = txtRoomTypeId.getText();
        String Type = txtType.getText();
        String keyMoney=txtKeyMoney.getText();
        int RoomQty = Integer.parseInt(txtRoomQty.getText());



        if(roomService.addRoom(new RoomDTO(RoomTypeId,Type,keyMoney,RoomQty))){
            new Alert(Alert.AlertType.CONFIRMATION,"Room added!").show();
            loadRoomDetails();
            ClearMethod();
        }
    }

    private void ClearMethod(){

        txtRoomTypeId.clear();
        txtType.clear();
        txtKeyMoney.clear();
        txtRoomQty.clear();

    }

    public void btnEditOnAction(ActionEvent actionEvent) throws IOException {
        String RoomTypeId = txtRoomTypeId.getText();
        String Type = txtType.getText();
        String keyMoney=txtKeyMoney.getText();
        int RoomQty = Integer.parseInt(txtRoomQty.getText());


        if(roomService.UpdateRoom(new RoomDTO(RoomTypeId,Type,keyMoney,RoomQty))){
            new Alert(Alert.AlertType.CONFIRMATION,"Room Updated!").show();
            loadRoomDetails();
            ClearMethod();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws IOException {
        String id = txtRoomTypeId.getText();

        try {boolean isDeleted = roomService.DeleteRoom(id);
            tblRoom.refresh();
            loadRoomDetails();
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room deleted..!");
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong..!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

