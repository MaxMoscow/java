package ru.lanit.service;

import  ru.lanit.exceptions.*;
import  ru.lanit.persist.Rx;
import  java.util.List;

public interface RxService
{

	public void save( Rx rx );
	public List<Rx> findByDoctorId  ( int id ) throws UserNotFoundException;
	public List<Rx> findByPatientId ( int id ) throws UserNotFoundException;

}
