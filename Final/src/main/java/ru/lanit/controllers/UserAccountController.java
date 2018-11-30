package ru.lanit.controllers;

import org.springframework.ui.ModelMap;
import ru.lanit.domain.*;
import ru.lanit.exceptions.UnmatchingUserCredentialsException;
import ru.lanit.helpers.ExecutionStatus;
import ru.lanit.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping ( "/account" )
public class UserAccountController
{
    private UserService   userService;
    private DoctorService docService;

    final static Logger logger = LoggerFactory.getLogger ( UserAccountController.class );

    @Autowired
    public UserAccountController ( UserService userService )
    {
        this.userService = userService;
    }

    public UserAccountController ( UserService userService, DoctorService doctorService )
    {
        this.userService = userService;
        this.docService  = doctorService;
    }

//  TODO
	@PostMapping ( value = "/signup", produces = {"application/json"} )
	public ExecutionStatus processSignup()
	{
        userService.processSignup();
        ExecutionStatus status = new ExecutionStatus("DOCTOR_LOGIN_SUCCESSFUL", "Login Successful!" );
        return status;
    }

    @PostMapping(value = "/login")
    public ExecutionStatus processLogin ( ModelMap model, @RequestBody User reqUser, HttpServletRequest request )
    {
        User user = userService.isValidUser(reqUser.getEmail(), reqUser.getPassword());
        logger.debug(reqUser.getEmail() );
        if ( user == null ) return new ExecutionStatus("USER_LOGIN_SUCCESSFUL", "Login Successful!" );
        else                return new ExecutionStatus("FAILURE", "Username or password is incorrect. Please try again!" );
    }

	@GetMapping ( value = "/users", produces = {"application/json"} )
	public List<User> getAllUsers()	{ return userService.getAll(); }
	@GetMapping ( value = "/users/{mail}", produces = {"application/json"} )
	public User findItem ( @PathVariable("mail") String email ) /* throws UserNotFoundException */ { return userService.getByEmail(email); }

}
