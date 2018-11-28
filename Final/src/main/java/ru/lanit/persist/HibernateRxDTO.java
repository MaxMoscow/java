package ru.lanit.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class HibernateRxDTO implements RxDTO
{
	private SessionFactory sessionFactory;

    public HibernateRxDTO(){};
    public HibernateRxDTO(SessionFactory sessionFactory){
	    this.sessionFactory = sessionFactory;
    }

    public void save ( Rx rx ) {
        Session s = sessionFactory.getCurrentSession();
        s.save ( rx );
        return;
    }

    public List<Rx> findByDoctorId ( int id ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Rx WHERE doctorId = :id" );
        q.setParameter ( "id", id );
        List<Rx> rxs = q.list();
        return rxs;
    }

    public List<Rx> findByPatientId ( int id ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Rx WHERE userId = :id" );
        q.setParameter ( "id", id );
        List<Rx> rxs = q.list();
        return rxs;
    }

    public List<Rx> findAll() {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Rx" );
        return q.list();
    }

}
