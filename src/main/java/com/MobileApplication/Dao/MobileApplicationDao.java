package com.MobileApplication.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MobileApplication.Entity.MobileApplication;
import com.MobileApplication.Repositary.MobileApplicationRepo;

@Repository
public class MobileApplicationDao {
	@Autowired
	MobileApplicationRepo mr;
	
	public String insertAppDetails(List<MobileApplication> m) {
		mr.saveAll(m);
		return "App Details Inserted"; 
	}
	
	public MobileApplication getMaxObject() {
		return mr.getMaxObject();
	}
	
	public List<MobileApplication> getBetweenObjectUsingOperator(int a,int b){
		return mr.getBetweenObjectUsingOperator(a, b);
	}
	
	public List<MobileApplication> getObjectByName(String n){
		return mr.getObjectByName(n);
	}
	
	public List<MobileApplication> getObjectById(int a) {
		return mr.getObjectById(a);
	}
	
//	public List<MobileApplication> getObjectUsingStartsWith(){
//		return mr.getObjectUsingStartsWith();
//	}


}
