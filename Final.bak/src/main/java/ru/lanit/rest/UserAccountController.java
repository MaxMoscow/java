package ru.lanit.rest;

import ru.lanit.persist.*;
import ru.lanit.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;
import java.util.List;
import javax.xml.bind.annotation.*;

@RestController
@RequestMapping ( "/account" )
public class UserAccountController
{
	@Autowired
	UserDAO dao;

    final static Logger logger = LoggerFactory.getLogger(UserAccountController.class);

//  TODO
	@PostMapping ( value = "/signup", produces = {"application/json"} )
	public void processSignup()
	{
	    dao.processSignup();
        return;
    }

	@GetMapping ( value = "/users", produces = {"application/json"} )
	public Object getAllUsers()
	{
		List<User> results = (List<User>)dao.getAll();
		return new ObjectWithList(results);
	}

	@GetMapping     ( value = "/users/{id}", produces = {"application/json"} )
//	@RequestMapping ( value = "/{id}", headers  = {"application/json"} )
	public User findItem (@PathVariable("id") Long id )	{ return dao.findById ( id ); }

////
	public class ObjectWithList
	{
        private List<User> list;

	    public ObjectWithList ( List<User> listIn )	{ list = listIn; }

        @XmlElementWrapper(name="MyList")
		@XmlElement
	    public List<User> getList()                  { return list;	  }
	    public void       setList(List<User> listIn) { list = listIn; }
    }

}
