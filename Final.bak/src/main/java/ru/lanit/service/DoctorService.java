package ru.lanit.service;

import ru.lanit.exceptions.*;
import ru.lanit.persist.*;
import java.util.List;

public interface DoctorService
{

	public Doctor save ( Doctor doctor );
    public List<Doctor> findBySpeciality ( String speciality ) throws UnmatchingUserCredentialsException;
    public List<Doctor> findAll();
    public Doctor findByUserEmailAddress(String email) throws UserNotFoundException;
    public int findCount();
    public Doctor findByUserId(int id) throws UserNotFoundException;
    public void addDoctor(Doctor doctor);

}
