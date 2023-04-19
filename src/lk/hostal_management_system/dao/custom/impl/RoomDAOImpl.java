package lk.hostal_management_system.dao.custom.impl;

import lk.hostal_management_system.dao.custom.RoomDAO;
import lk.hostal_management_system.entity.Room;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Room entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean deleteByPK(String pk) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room load = session.load(Room.class, pk);
        session.delete(load);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Room> findAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Room";
        List<Room>RoomList = session.createQuery(hql).list();

        transaction.commit();
        session.close();

        return RoomList;
    }

    @Override
    public boolean findByPk(String pk) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, pk);

        transaction.commit();
        session.close();

        return true;
    }




}
