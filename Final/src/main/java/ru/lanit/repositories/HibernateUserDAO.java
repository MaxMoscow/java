package ru.lanit.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.domain.User;

import java.util.List;

@Transactional
public class HibernateUserDAO implements UserDAO
{
	private SessionFactory sessionFactory;

    public HibernateUserDAO(){};
    public HibernateUserDAO(SessionFactory sessionFactory){
	    this.sessionFactory = sessionFactory;
    }

    public User save (User user ) {
        Session s = sessionFactory.getCurrentSession();
        s.save ( user );
        return user;
    }

    public void update ( User user ) {
        Session s = sessionFactory.getCurrentSession();
        s.update ( user );
    }

    public User getByEmail ( String email ) {
        User user = null;
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM User WHERE email LIKE :email" );
        q.setParameter ("email", email );
        List<User> users = q.list();
        if  ( users.size() > 0 ) user = users.get(0);
        return user;
    }

    public List<User> findByEmailAndPassword ( String email, String password ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM User WHERE email LIKE :email and password LIKE :password" );
        q.setParameter ( "email",    email );
        q.setParameter ( "password", password );
        List<User> user = q.list();
        return user;
    }

    public User       findById(Long id) { return sessionFactory.getCurrentSession().get(User.class, id); }
    public List<User> getAll()          { return sessionFactory.getCurrentSession().createQuery("FROM User").list(); }

    public void processSignup()
    {
    }

}
