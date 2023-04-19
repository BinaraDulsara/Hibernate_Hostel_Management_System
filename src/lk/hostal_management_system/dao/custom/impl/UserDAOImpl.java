package lk.hostal_management_system.dao.custom.impl;

import lk.hostal_management_system.dao.custom.UserDAO;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.entity.User;
import lk.hostal_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(User entity) throws IOException {
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

        User load = session.load(User.class, pk);
        session.delete(load);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<User> findAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        List <User>UserList = session.createQuery(hql).list();

        transaction.commit();
        session.close();

        return UserList;
    }

    @Override
    public boolean findByPk(String pk) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, pk);

        transaction.commit();
        session.close();

        return true;
    }


}
