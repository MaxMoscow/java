package ru.lanit.persist;

import  ru.lanit.exceptions.UnmatchingUserCredentialsException;
import  java.util.List;

public interface DoctorDAO
{

    public void save(Doctor doctor);
    public List<Doctor> findBySpeciality(String speciality);
    public List<Doctor> findAll();
    public Doctor findByUserEmailAddress(String email);
    public int findAllCount();
    public Doctor findByUserId(int id);
    public void addDoctor(Doctor doctor);

}
