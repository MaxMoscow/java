package ru.lanit.controllers;

import ru.lanit.domain.*;
import ru.lanit.repositories.*;
import ru.lanit.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import org.slf4j.*;
import java.util.List;

@RestController
@RequestMapping ( "/rx" )
public class RxController
{
    private RxService     rxService;
    private UserService   userService;
    private DoctorService docService;

    final  static Logger logger = LoggerFactory.getLogger ( UserAccountController.class );

	@Autowired
	public RxController ( RxService rxService ) { this.rxService = rxService; }

	@GetMapping ( produces = {"application/json"} )
	public List<RxDAO> getRx()
	{
        List<RxDAO> results = rxService.findAll();
        return results;
	}

	@PostMapping ( value = "/new", produces = {"application/json"} )
	public Rx createRx ( ModelMap map, @RequestBody RxDTO rxDTO )
	{
	    Rx rx = new Rx();
	    rx.setUserId   ( Long.parseLong(rxDTO.getPatientId()) );
	    rx.setMedicine ( rxDTO.getMedicine() );
	    rx.setSymptoms ( rxDTO.getSymptoms() );
		rxService.save ( rx );
		return rx;
	}

    private User getUser(){
        User user = null;
        return user;
    }

    private String getUserEmailAddress(){
        String email = null;
        return email;
    }

}
