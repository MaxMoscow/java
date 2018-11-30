package ru.lanit.services;

import  ru.lanit.domain.*;
import  ru.lanit.repositories.RxDAO;
import  java.util.List;

public interface RxService
{
	public void save( Rx rx );
	public List<Rx> findByDoctorId  ( int id ); // throws UserNotFoundException;
	public List<Rx> findByPatientId ( int id ); // throws UserNotFoundException;
	public List<RxDAO> findAll();
}
