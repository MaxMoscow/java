package ru.lanit.persist;

import ru.lanit.exceptions.UnmatchingUserCredentialsException;

import java.util.Collection;
import java.util.List;

public interface UserDAO
{

    public User save          ( User   user  );
    public void update        ( User   user  );
    public User doesUserExist ( String name  );
    public User getByEmail    ( String email );
    public User isValidUser   ( String a, String b ) throws UnmatchingUserCredentialsException;
    public List<User> findByEmailAndPassword(String email, String password);

//  public boolean isEmpty    ( User   user  );
    public User findById      ( Long   id    );
    public Collection<User> getAll();

    public void processSignup();

}
