package ru.lanit.rest;

import ru.lanit.persist.*;
import ru.lanit.service.*;
import ru.lanit.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorSearchController
{
    DoctorService doctorService;

    @Autowired
    public DoctorSearchController ( DoctorService docService ) { this.doctorService = docService; }
    final static Logger logger = LoggerFactory.getLogger ( UserAccountController.class );

    @GetMapping ( value = "/all", produces = {"application/json"} )
    public List<Doctor> findAll()
    {
        List<Doctor> doctors = doctorService.findAll();
//  TODO
        doctors.forEach ( doctor->logger.debug ( doctor.toString() ) );
        return doctors;
    }

//  public Doctor[] getBySpecialityCode(ModelMap model, @RequestBody String speciality ) {
//      Doctor[] doctors = doctorService.getBySpeciality ( speciality );

    @GetMapping ( value = "/{code}", produces = {"application/json"} )
    public List<Doctor> getBySpecialityCode ( @PathVariable("code") String speciality ) throws UnmatchingUserCredentialsException {
        List<Doctor> doctors = doctorService.findBySpeciality ( speciality );
        return doctors;
    }

    @GetMapping ( value = "/count", produces = {"application/json"} )
    public int getDoctorCount()
    {
        int count = doctorService.findCount();
        return count;

    }

}
