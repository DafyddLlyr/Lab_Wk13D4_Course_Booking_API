package com.codeclan.example.coursebookingservice.repositories.customerrepository;

import com.codeclan.example.coursebookingservice.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> findCustomersByCourse(Long id) {
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", id));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Customer> findCustomerByCourseIDAndTown(Long id, String town) {
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", id));
            cr.add(Restrictions.eq("town", town));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Customer> findCustomerByCourseIDTownAndAge(Long id, String town, int age){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.course.id", id));
            cr.add(Restrictions.eq("town", town.toLowerCase()));
            cr.add(Restrictions.gt("age", age));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

}
