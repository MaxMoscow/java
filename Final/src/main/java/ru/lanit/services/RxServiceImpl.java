package ru.lanit.services;

import org.springframework.transaction.annotation.Transactional;
import ru.lanit.domain.*;
import ru.lanit.repositories.*;
import java.util.List;

@Transactional
public class RxServiceImpl implements RxService
{
    RxDAO dao;

	public RxDAO getDao()          { return     dao; }
	public void  setDao(RxDAO dao) {
		this.dao = dao;
	}

	public void save ( Rx rx ) {
		dao.save ( rx );
		return;
	}

	public List<Rx> findByDoctorId ( int id ) // throws UserNotFoundException
	{
		List<Rx> rxs = dao.findByDoctorId ( id );
//		if  ( rxs == null )  throw new UserNotFoundException("User does not exist.");
		return rxs;
	}

    public List<Rx> findByPatientId ( int id ) // throws UserNotFoundException
    {
        List<Rx> rxs = dao.findByPatientId ( id );
//		if  ( rxs == null )  throw new UserNotFoundException("User does not exist.");
        return rxs;
    }

    public List<RxDAO> findAll() { return dao.findAll(); }

}
