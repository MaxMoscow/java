package ru.lanit.service;

import ru.lanit.exceptions.*;
import ru.lanit.persist.User;

public interface UserService
{

	public User save          ( User   user  );
	public void update        ( User   user  );
	public User getByEmail    ( String email )                  throws UserNotFoundException;
	public User doesUserExist ( String email )                  throws UserNotFoundException;
	public User isValidUser   ( String email, String password ) throws UnmatchingUserCredentialsException;

//	public long findCount();
//  public void runTest();
//	public void checkResults();

	public void processSignup();

}
