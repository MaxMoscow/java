package ru.lanit.service;

import org.springframework.transaction.annotation.Transactional;
import ru.lanit.exceptions.*;
import ru.lanit.persist.*;
import java.util.List;

@Transactional
public class DoctorServiceImpl implements DoctorService
{
	DoctorDAO dao;

	public DoctorDAO getDao()              { return     dao; }
	public void      setDao(DoctorDAO dao) {
		this.dao = dao;
	}

	public Doctor save ( Doctor doctor ) {
		dao.save ( doctor );
		return doctor;
	}

	public List<Doctor> findBySpeciality ( String speciality ) throws UnmatchingUserCredentialsException {
        List<Doctor> doctors = (List<Doctor>) dao.findBySpeciality(speciality);
        if  ( doctors == null || doctors.size() == 0 ) throw new UnmatchingUserCredentialsException ( "Doctor with given credentials is not found." );
        return doctors;
    }

	public List<Doctor> findAll() {
        List<Doctor> doctors = (List<Doctor>) dao.findAll();
        return doctors;
    }

	public Doctor findByUserEmailAddress ( String email ) throws UserNotFoundException {
        Doctor doctor = dao.findByUserEmailAddress ( email );
        if  ( doctor == null )  throw new UserNotFoundException ( "Doctor does not exist." );
        return doctor;
    }

	public int findCount() {
        int count = dao.findAllCount();
        return count;
    }

	public Doctor findByUserId ( int id ) throws UserNotFoundException {
        Doctor doctor = dao.findByUserId ( id );
        if  ( doctor == null )  throw new UserNotFoundException ( "Doctor does not exist." );
        return doctor;
    }

	public void addDoctor ( Doctor doctor )
	{
		dao.save ( doctor );
		return;
	}

}
