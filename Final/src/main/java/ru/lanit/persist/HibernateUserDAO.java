package ru.lanit.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.exceptions.UnmatchingUserCredentialsException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Transactional
public class HibernateUserDAO implements UserDAO
{
	private SessionFactory sessionFactory;

    public HibernateUserDAO(){};
    public HibernateUserDAO(SessionFactory sessionFactory){
	    this.sessionFactory = sessionFactory;
    }

    public User save ( User user ) {
        Session s = sessionFactory.getCurrentSession();
        s.save ( user );
        return user;
    }

    public void update ( User user ) {
        Session s = sessionFactory.getCurrentSession();
        s.update ( user );
    }

    public User doesUserExist ( String name  ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery("FROM User WHERE email LIKE :email" );
        q.setParameter ("email", name );
        return (User) q.list().get(0);
    }

    public User getByEmail ( String email )
    {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery("FROM User WHERE email LIKE :email" );
        q.setParameter ("email", email );
        return (User) q.list().get(0);
    }

    public User isValidUser ( String email, String password ) throws UnmatchingUserCredentialsException {
        Session s = sessionFactory.getCurrentSession();
        Query q = s.createQuery("FROM User WHERE email LIKE :email AND password LIKE :password" );
        q.setParameter ("email", email );
        q.setParameter ("password", password );

        ArrayList<User> queryList = new ArrayList<User>(q.list());
        if ( queryList.isEmpty() ) throw new UnmatchingUserCredentialsException ( "No User Account found");
        return (User) queryList.get(0);
    }

    public List<User> findByEmailAndPassword ( String email, String password ) {
        Session s = sessionFactory.getCurrentSession();
        Query   q = s.createQuery ("FROM User WHERE email LIKE :email and password LIKE :password" );
        q.setParameter ( "email",    email );
        q.setParameter ( "password", password );
        List<User> user = q.list();
        return user;
    }

    public User findById(Long id) {
        Session s = sessionFactory.getCurrentSession();
        User user = (User)s.get(User.class, id);
        return user;
    }

    public Collection<User> getAll() {
        Session s = sessionFactory.getCurrentSession();
        Query q = s.createQuery("FROM User");
        return q.list();
    }

    public void processSignup()
    {

    }

}
