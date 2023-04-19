package lk.hostal_management_system.service.custom;

import lk.hostal_management_system.dto.RoomDTO;
import lk.hostal_management_system.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface RoomService extends SuperService {

    List<RoomDTO> getAllRoomDetails() throws IOException;

    boolean addRoom(RoomDTO roomDTO) throws IOException;

    boolean UpdateRoom(RoomDTO roomDTO) throws IOException;

    boolean DeleteRoom(String Id) throws IOException;
}
