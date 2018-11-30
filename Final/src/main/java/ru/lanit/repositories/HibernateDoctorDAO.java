package ru.lanit.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.domain.Doctor;

import java.util.List;

@Transactional
public class HibernateDoctorDAO implements DoctorDAO
{
	private SessionFactory sessionFactory;

    public HibernateDoctorDAO(){};
    public HibernateDoctorDAO(SessionFactory sessionFactory){
	    this.sessionFactory = sessionFactory;
    }

    public void save ( Doctor doctor ) {
        Session s = sessionFactory.getCurrentSession();
        s.save ( doctor );
        return;
    }

    public List<Doctor> findBySpeciality ( String speciality ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Doctor WHERE specialityCode LIKE :speciality" );
        q.setParameter ("speciality", "%"+speciality+"%" );
        List<Doctor> doctors = q.list();
        return doctors;
    }

    public List<Doctor> findAll() {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Doctor" );
        List<Doctor> doctors = q.list();
        return doctors;
    }

//  TODO
    public Doctor findByUserEmailAddress ( String email ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Doctor WHERE User.email LIKE :email" );
        q.setParameter ( "email",    email );
        Doctor doctor = (Doctor)q.list().get(0);
        return doctor;
    }

    public int findAllCount() {
        Session  s = sessionFactory.getCurrentSession();
        Query    q = s.createQuery ("SELECT count(*) FROM Doctor" );
        Long count = (Long) q.list().get(0);
        return count.intValue();
    }

    public Doctor findByUserId ( int id ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM Doctor WHERE userId = :id" );
        q.setParameter ("id", id );
        Doctor doctor = (Doctor)q.list().get(0);
//      Doctor doctor = (Doctor)s.get(Doctor.class, id);
        return doctor;
    }

    public void addDoctor ( Doctor doctor ) {
        Session s = sessionFactory.getCurrentSession();
        s.save ( doctor );
        return;
    }

}
