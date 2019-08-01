package com.codeclan.example.coursebookingservice.repositories.courserepository;

import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getCourseByCustomer(Long id) {
        List<Course> result = null;
        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "booking");
            cr.add(Restrictions.eq("booking.customer.id", id));
            result = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

}
