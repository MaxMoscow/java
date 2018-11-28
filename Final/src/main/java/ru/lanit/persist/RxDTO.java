package ru.lanit.persist;

//import ru.lanit.exceptions.UnmatchingUserCredentialsException;

import java.util.Collection;
import java.util.List;

public interface RxDTO
{

    public void save ( Rx rx );
    public List<Rx> findByDoctorId  ( int id );
    public List<Rx> findByPatientId ( int id );

    public List<Rx> findAll();

}
