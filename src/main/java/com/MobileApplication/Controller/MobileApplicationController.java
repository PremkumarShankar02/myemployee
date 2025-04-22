package com.MobileApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MobileApplication.Entity.MobileApplication;
import com.MobileApplication.Exception.IdNotFoundException;
import com.MobileApplication.Exception.NameException;
import com.MobileApplication.Exception.UserNotFoundException;
import com.MobileApplication.Service.MobileApplicationService;

@RestController
public class MobileApplicationController {
	@Autowired
	MobileApplicationService ms;
	
	@PostMapping(value="insertappdetails")
	public String insertAppDetails(@RequestBody List<MobileApplication> m) {
		return ms.insertAppDetails(m);
	}

	@GetMapping(value="getmaxobject")
	public MobileApplication getMaxObject() {
		return ms.getMaxObject();
	}
	@GetMapping(value="getbetweenobjectusingoperator/{a}/{b}")
	public List<MobileApplication> getBetweenObjectUsingOperator(@PathVariable int a,@PathVariable int b) throws UserNotFoundException{
		return ms.getBetweenObjectUsingOperator(a, b);
	}
	
	@GetMapping(value="getobjectbyname/{n}")
	public List<MobileApplication> getObjectByName(@PathVariable String n) throws NameException {
		return ms.getObjectByName(n);
	}
	@GetMapping(value="getobjectbyid/{a}")
	public List<MobileApplication> getObjectById(@PathVariable int a) throws IdNotFoundException{
		return ms.getObjectById(a);
	}
	

	
}
