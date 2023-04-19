package lk.hostal_management_system.service.custom.impl;

import lk.hostal_management_system.dao.DAOFactory;
import lk.hostal_management_system.dao.custom.RoomDAO;
import lk.hostal_management_system.dto.RoomDTO;
import lk.hostal_management_system.entity.Room;
import lk.hostal_management_system.service.custom.RoomService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List<RoomDTO> getAllRoomDetails() throws IOException {
        List<Room> getRoom = roomDAO.findAll();
        List<RoomDTO> getRoomDetails = new ArrayList<>();
        for (Room room : getRoom){
            getRoomDetails.add(new RoomDTO(
                    room.getRoomTypeID(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getRoomQty()
            ));
        }
        return getRoomDetails;
    }

    @Override
    public boolean addRoom(RoomDTO roomDTO) throws IOException {
        return roomDAO.save(new Room(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getRoomQty()
        ));
    }

    @Override
    public boolean UpdateRoom(RoomDTO roomDTO) throws IOException {
        return roomDAO.update(new Room(
           roomDTO.getRoomTypeID(),
           roomDTO.getType(),
           roomDTO.getKeyMoney(),
           roomDTO.getRoomQty()
        ));
    }

    @Override
    public boolean DeleteRoom(String Id) throws IOException {
        return roomDAO.deleteByPK(Id);
    }
}
