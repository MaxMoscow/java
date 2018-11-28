package ru.lanit.rest;

import ru.lanit.persist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ( "/rx" )
public class RxController
{
	@Autowired
	RxDTO dto;

	@GetMapping ( produces = {"application/json"} )
	public List<Rx> getRx()
	{
	    List<Rx> results = dto.findAll();
        return results;
	}

//  TODO
	@PostMapping ( value = "/new", produces = {"application/json"} )
	public Object createRx ( )
	{
//		(List<User>)dto.create();
		return null;
	}

}
