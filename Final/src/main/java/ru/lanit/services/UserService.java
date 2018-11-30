package ru.lanit.services;

import ru.lanit.domain.User;
import java.util.List;

public interface UserService
{

	public User save          ( User   user  );
	public void update        ( User   user  );
	public User doesUserExist ( String email );                  // throws UserNotFoundException;
	public User getByEmail    ( String email );                  // throws UserNotFoundException;
	public User isValidUser   ( String email, String password ); // throws UnmatchingUserCredentialsException;
    public List<User> getAll();
	public void processSignup();

}
