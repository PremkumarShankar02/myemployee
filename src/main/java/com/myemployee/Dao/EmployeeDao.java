package com.myemployee.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myemployee.Entity.EmployeeEntity;
import com.myemployee.Repository.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepo er;
	
	public String insertObject(EmployeeEntity e) {
		er.save(e);
		return "Inserted Employee Object Successfully";
	}
	public String insertListOfObject(List<EmployeeEntity> e1) {
		er.saveAll(e1);
		
		return "Updated Successfully";
	}
	
	public List<EmployeeEntity> getAllObject(){
		return er.findAll();
	}
	
	public String updateById(EmployeeEntity e) {
		er.save(e);
		return "Updated the employee successfully";
	}

	
	public String updateName(EmployeeEntity e,int a) {
		
	     EmployeeEntity x=er.findById(a).get();
	     x.setName(e.getName());
	     er.save(x);
		return "Name Field Updated Successfully"; 
	}
	//Queries methods
	public List<EmployeeEntity> getBetweenSalUsingNative(int a,int b){
		return er.getBetweenSalUsingNative(a, b);
	}
	public List<EmployeeEntity> getBetweenSalUsingJquery(int a,int b){
		return er.getBetweenSalUsingJquery(a, b);
	}
	
	public EmployeeEntity getEmpDetailByName(String a) {
		return er.getEmpDetailByName(a);
	}
	
	public List<EmployeeEntity> getObjectByStartingLetter(){
		return er.getObjectByStartingLetter();
	}
	
	public List<EmployeeEntity> getObjectByStartingLetterUsingParameter(char a){
		return er.getObjectByStartingLetterUsingParameter(a);
	}
	
	public EmployeeEntity getMaxSalWithObject() {
		return er.getMaxSalWithObject();
	}
	
	public List<EmployeeEntity> getObjectOrderOfSalaryDesc(){
		return er.getObjectOrderOfSalaryDesc();
	}
	
	public EmployeeEntity getSecondMaxSalWithObject() {
		return er.getSecondMaxSalWithObject();
	}
	
	public Long getGroupOfNameUsingEndsWith(String x){
		return er.getGroupOfNameUsingEndsWith(x);
	}
	
	public int getSumOfSalaryUsingLikeOperator() {
		return er.getSumOfSalaryUsingLikeOperator();
	}
	
	public List<Object[]> getGroupOfGenderWithAvgSal(){
		return er.getGroupOfGenderWithAvgSal();
	}
}
