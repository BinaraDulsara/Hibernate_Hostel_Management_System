package lk.hostal_management_system.dao.custom.impl;

import lk.hostal_management_system.dao.custom.StudentDAO;
import lk.hostal_management_system.dto.StudentDTO;
import lk.hostal_management_system.entity.Student;
import lk.hostal_management_system.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Student entity) throws IOException {
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

        Student load = session.load(Student.class,pk);
        session.delete(load);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Student> findAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM Student";
        List<Student>StudentList = session.createQuery(hql).list();

        transaction.commit();
        session.close();

        return StudentList;
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
