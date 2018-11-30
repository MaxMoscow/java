package ru.lanit.repositories;

import ru.lanit.domain.Rx;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
public class HibernateRxDAO implements RxDAO
{
	private SessionFactory sessionFactory;

    public HibernateRxDAO(){};
    public HibernateRxDAO(SessionFactory sessionFactory){
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

    public List<RxDAO> findAll() { return sessionFactory.getCurrentSession().createQuery ("FROM Rx" ).list(); }

}
