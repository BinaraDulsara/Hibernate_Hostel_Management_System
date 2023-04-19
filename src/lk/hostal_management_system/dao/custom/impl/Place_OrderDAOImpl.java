package lk.hostal_management_system.dao.custom.impl;

import lk.hostal_management_system.dao.custom.Place_OrderDAO;
import lk.hostal_management_system.entity.Reservation;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class Place_OrderDAOImpl implements Place_OrderDAO {
    @Override
    public boolean save(Reservation entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Reservation entity) throws IOException {
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

        Reservation load = session.load(Reservation.class, pk);
        session.delete(load);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Reservation> findAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        List<Reservation> Place_Orderlist = session.createQuery(hql).list();

        transaction.commit();
        session.close();

        return Place_Orderlist;
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
