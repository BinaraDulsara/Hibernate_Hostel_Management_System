package lk.hostal_management_system.service.custom;

import lk.hostal_management_system.dto.ReservationDTO;
import lk.hostal_management_system.dto.StudentDTO;
import lk.hostal_management_system.service.SuperService;

import java.io.IOException;
import java.util.List;

public interface ReservationService extends SuperService {

    List<ReservationDTO> getAllReservationDetails() throws IOException;

    boolean addReservations(ReservationDTO reservationDTO) throws IOException;

    boolean UpdateReservations(ReservationDTO reservationDTO) throws IOException;

    boolean DeleteReservations(String id) throws IOException;

}
