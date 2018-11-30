package ru.lanit.repositories;

import ru.lanit.domain.User;
import java.util.List;

public interface UserDAO
{

    public User save          (User   user  );
    public void update        ( User   user  );
    public User getByEmail    ( String email );
    public List<User> findByEmailAndPassword ( String email, String password );
    public List<User> getAll();
    public void processSignup();

}
