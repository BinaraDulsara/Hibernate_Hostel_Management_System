package lk.hostal_management_system.service.custom.impl;

import lk.hostal_management_system.dao.DAOFactory;
import lk.hostal_management_system.dao.custom.Place_OrderDAO;
import lk.hostal_management_system.dto.ReservationDTO;
import lk.hostal_management_system.service.custom.ReservationService;

import java.io.IOException;
import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    Place_OrderDAO reservationDAO = (Place_OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public List<ReservationDTO> getAllReservationDetails() throws IOException {
        /*List<Place_Order> getPlace_order = Place_OrderDAO.getReservationDetails();
        List<StudentDTO> getStudentsDetails=new ArrayList<>();*/
        return null;
    }

    @Override
    public boolean addReservations(ReservationDTO reservationDTO) throws IOException {
        return false;
    }

    @Override
    public boolean UpdateReservations(ReservationDTO reservationDTO) throws IOException {
        return false;
    }

    @Override
    public boolean DeleteReservations(String id) throws IOException {
        return false;
    }
}
