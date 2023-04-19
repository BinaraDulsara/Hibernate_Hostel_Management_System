package lk.hostal_management_system.dao;

import lk.hostal_management_system.entity.Room;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.entity.SuperEntity;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface CrudDAO <T extends SuperEntity,ID extends Serializable > extends SuperDAO {


    boolean save(T entity) throws IOException;

    boolean update (T entity) throws IOException;

    boolean deleteByPK(ID pk) throws IOException;

    List <T> findAll() throws IOException;

    boolean findByPk(ID pk) throws IOException;


}
