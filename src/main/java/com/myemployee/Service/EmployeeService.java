package com.myemployee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myemployee.Dao.EmployeeDao;
import com.myemployee.Entity.EmployeeEntity;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	
	public String insertObject(EmployeeEntity e) {
		return ed.insertObject(e);
	}
	public String insertListOfObject(List<EmployeeEntity> e1) {
		return ed.insertListOfObject(e1);
	}

	
	public List<EmployeeEntity> getAllObject(){
		return ed.getAllObject();
	}
	
	public String updateById(EmployeeEntity e) {
		return ed.updateById(e);
	}
	
	
	public String updateName(EmployeeEntity e,int a) {
		return ed.updateName(e,a);
}
	//Queries methods
	public List<EmployeeEntity> getBetweenSalUsingNative(int a,int b){
		return ed.getBetweenSalUsingNative(a, b);
	}
	
	public List<EmployeeEntity> getBetweenSalUsingJquery(int a,int b){
		return ed.getBetweenSalUsingJquery(a, b);
	}
	
	public EmployeeEntity getEmpDetailByName(String a) {
		return ed.getEmpDetailByName(a);
	}
	
	public List<EmployeeEntity> getObjectByStartingLetter(){
		return ed.getObjectByStartingLetter();
	}
	
	public List<EmployeeEntity> getObjectByStartingLetterUsingParameter(char a){
		return ed.getObjectByStartingLetterUsingParameter(a);
	}
	
	public EmployeeEntity getMaxSalWithObject() {
		return ed.getMaxSalWithObject();
	}
	
	public List<EmployeeEntity> getObjectOrderOfSalaryDesc(){
		return ed.getObjectOrderOfSalaryDesc();
	}
	
	public EmployeeEntity getSecondMaxSalWithObject() {
		return ed.getSecondMaxSalWithObject();
	}
	
	public Long getGroupOfNameUsingEndsWith(String x){
		return ed.getGroupOfNameUsingEndsWith(x);
	}
	
	public int getSumOfSalaryUsingLikeOperator() {
		return ed.getSumOfSalaryUsingLikeOperator();
	}
	
	public List<Object[]> getGroupOfGenderWithAvgSal(){
		return ed.getGroupOfGenderWithAvgSal();
	}
	
}
