package ru.lanit.repositories;

import ru.lanit.domain.Rx;
import java.util.List;

public interface RxDAO
{

    public void save ( Rx rx );
    public List<Rx> findByDoctorId  ( int id );
    public List<Rx> findByPatientId ( int id );

    public List<RxDAO> findAll();

}
