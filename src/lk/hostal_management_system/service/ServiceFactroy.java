package lk.hostal_management_system.service;

import lk.hostal_management_system.service.custom.impl.ReservationServiceImpl;
import lk.hostal_management_system.service.custom.impl.RoomServiceImpl;
import lk.hostal_management_system.service.custom.impl.StudentServiceImpl;
import lk.hostal_management_system.service.custom.impl.UserServiceImpl;

import static javafx.scene.input.KeyCode.T;

public class ServiceFactroy {

    private static ServiceFactroy boFactory;
    private ServiceFactroy(){

    }

    public static ServiceFactroy getBoFactory(){
        return (boFactory==null)? boFactory=new ServiceFactroy() : boFactory;
    }
    public  enum BOTypes{
        ROOM,STUDENT,RESERVATION,USER
    }
    public SuperService getBO(BOTypes types){
        switch(types){
            case ROOM:
                return new RoomServiceImpl();
            case STUDENT:
                return new  StudentServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            case USER:
                return new UserServiceImpl();
            default:
                return null;
        }
    }
}
