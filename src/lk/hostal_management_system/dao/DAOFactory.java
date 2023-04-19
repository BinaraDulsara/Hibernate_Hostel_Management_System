package lk.hostal_management_system.dao;

import lk.hostal_management_system.dao.custom.impl.Place_OrderDAOImpl;
import lk.hostal_management_system.dao.custom.impl.RoomDAOImpl;
import lk.hostal_management_system.dao.custom.impl.StudentDAOImpl;
import lk.hostal_management_system.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        ROOM, RESERVATION, STUDENT, USER
    }

    public Object getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new Place_OrderDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }
}