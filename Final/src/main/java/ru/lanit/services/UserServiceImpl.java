package ru.lanit.services;

import  ru.lanit.domain.*;
import  java.util.List;
import  org.springframework.transaction.annotation.Transactional;
import ru.lanit.repositories.UserDAO;

@Transactional
public class UserServiceImpl implements UserService
{
	UserDAO dao;

	public UserDAO getDao()            { return     dao; }
	public void    setDao(UserDAO dao) {
		this.dao = dao;
	}

	public User save ( User user ) {
		dao.save ( user );
		return user;
	}

	public void update ( User user ) {
		dao.update ( user );
		return;
	}

	public User doesUserExist ( String email ) // throws UserNotFoundException
	{
		User user = dao.getByEmail(email);
//      if  ( user == null ) throw new UserNotFoundException("User does not exist.");
		return user;
	}

	public User getByEmail ( String email ) // throws UserNotFoundException
    {
		User user = dao.getByEmail(email);
//		if  ( user == null )  throw new UserNotFoundException("User does not exist.");
		return user;
	}

	public User isValidUser ( String email, String password ) // throws UnmatchingUserCredentialsException
    {
	    User user = null;
	    List<User> users = (List<User>) dao.findByEmailAndPassword ( email, password );
//      if  ( users == null || users.size() == 0 ) throw new UnmatchingUserCredentialsException ( "User with given credentials is not found." );
        if  ( users != null && users.size() > 0 ) user = users.get(0);
		return user;
	}

	public List<User> getAll () { return dao.getAll(); }

	public void processSignup() {
        return;
	}

}
