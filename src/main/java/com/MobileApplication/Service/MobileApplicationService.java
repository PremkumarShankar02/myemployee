package com.MobileApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MobileApplication.Dao.MobileApplicationDao;
import com.MobileApplication.Entity.MobileApplication;
import com.MobileApplication.Exception.CharNotFoundException;
import com.MobileApplication.Exception.IdNotFoundException;
import com.MobileApplication.Exception.NameException;
import com.MobileApplication.Exception.UserNotFoundException;

@Service
public class MobileApplicationService {
	@Autowired
	MobileApplicationDao md;
	
	public String insertAppDetails(List<MobileApplication> m) {
		return md.insertAppDetails(m);
	}
	
	public MobileApplication getMaxObject() {
		return md.getMaxObject();
	}
	
	public List<MobileApplication> getBetweenObjectUsingOperator(int a,int b) throws UserNotFoundException{
		if(md.getBetweenObjectUsingOperator(a, b).isEmpty()) {
			throw new UserNotFoundException("Given User Count Not Present In Any App");
		}
		else {
			return md.getBetweenObjectUsingOperator(a, b);
		}
	}
	
	public List<MobileApplication> getObjectByName(String n) throws NameException{
		
		if(md.getObjectByName(n).isEmpty()) {
			 throw new NameException("The Given Name is Not Available");
		}
		else {
			return md.getObjectByName(n);
		}
	}
	
	public List<MobileApplication> getObjectById(int a) throws IdNotFoundException{
		if(md.getObjectById(a).isEmpty()) {
			throw new IdNotFoundException("Given Id Not Present");
		}
		else {
			return md.getObjectById(a);		
		}
	}
	
//	public List<MobileApplication> getObjectUsingStartsWith() throws CharNotFoundException{
//		if(md.getObjectUsingStartsWith().isEmpty()) {
//			throw
//		}
//	}

}
