package ru.lanit.service;

import  ru.lanit.exceptions.*;
import  ru.lanit.persist.*;
import  java.util.List;
import  org.springframework.transaction.annotation.Transactional;

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

	public User doesUserExist ( String email ) throws UserNotFoundException	{
		User user = dao.getByEmail(email);
		if  ( user == null ) throw new UserNotFoundException("User does not exist.");
		return user;
	}

	public User getByEmail ( String email ) throws UserNotFoundException {
		User user = dao.getByEmail(email);
		if  ( user == null )  throw new UserNotFoundException("User does not exist.");
		return user;
	}

	public User isValidUser ( String email, String password ) throws UnmatchingUserCredentialsException {
	    List<User> users = (List<User>) dao.findByEmailAndPassword ( email, password );
	    if  ( users == null || users.size() == 0 ) throw new UnmatchingUserCredentialsException ( "User with given credentials is not found." );
		return users.get(0);
	}

	public void processSignup() {
        return;
	}

}
