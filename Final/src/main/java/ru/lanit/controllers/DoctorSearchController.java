package ru.lanit.controllers;

import org.springframework.web.servlet.ModelAndView;
import ru.lanit.domain.*;
import ru.lanit.services.*;
import ru.lanit.helpers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorSearchController
{
    private DoctorService docService;

    @Autowired
    public DoctorSearchController ( DoctorService doctorService ) { this.docService = doctorService; }

    final  static Logger logger = LoggerFactory.getLogger ( UserAccountController.class );

    @GetMapping ( value = "/count", produces = {"application/json"} )
    public int getDoctorCount()
    {
        return docService.findCount();
    }

    @GetMapping ( value = "/all", produces = {"application/json"} )
//  public List<Doctor> findAll()
//  public ModelAndView findAll()
    public DoctorInfo findAll()
    {
        List<Doctor> doctors = docService.findAll();
        doctors.forEach ( doctor-> {
            logger.debug ( doctor.toString() );
        } );
        DoctorInfo doctorInfo = new DoctorInfo ( docService.findCount(), doctors, "" );
        return doctorInfo;
    }

    @GetMapping ( value = "/{code}", produces = {"application/json"} )
    public DoctorInfo getBySpecialityCode ( @PathVariable("code") String speciality )
//  public List<Doctor> getBySpecialityCode ( @PathVariable("code") String speciality ) // throws UnmatchingUserCredentialsException
//  public List<Doctor> getBySpecialityCode ( ModelMap model, @RequestBody String speciality ) {
    {
        List<Doctor> doctors = docService.findBySpeciality ( speciality );
        DoctorInfo doctorInfo = new DoctorInfo ( docService.findCount(), doctors, "" );
        return doctorInfo;
//      return doctors;
    }

}
