package ru.lanit.service;

import org.springframework.transaction.annotation.Transactional;
import ru.lanit.exceptions.*;
import ru.lanit.persist.*;
import java.util.List;

@Transactional
public class RxServiceImpl implements RxService
{
	RxDTO dto;

	public RxDTO getDto()            { return     dto; }
	public void    setDto(RxDTO dto) {
		this.dto = dto;
	}

	public void save ( Rx rx ) {
		dto.save ( rx );
		return;
	}

	public List<Rx> findByDoctorId ( int id) throws UserNotFoundException {
		List<Rx> rxs = (List<Rx>) dto.findByDoctorId ( id );
		if  ( rxs == null )  throw new UserNotFoundException("User does not exist.");
		return rxs;
	}

	public List<Rx> findByPatientId ( int id) throws UserNotFoundException {
		List<Rx> rxs = (List<Rx>) dto.findByPatientId ( id );
		if  ( rxs == null )  throw new UserNotFoundException("User does not exist.");
		return rxs;
	}

}
