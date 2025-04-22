package com.myemployee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myemployee.Entity.EmployeeEntity;
import com.myemployee.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	
	@PostMapping(value="/insertsingleobject")
	public String insertObject(@RequestBody EmployeeEntity e) {
		return es.insertObject(e);
	}
	
	@PostMapping(value="/insertlistofobject")
	public String insertListOfObject(@RequestBody List<EmployeeEntity> e1) {
		return es.insertListOfObject(e1);
	}
	
	@GetMapping(value="/getlistofemployeeobject")
	public List<EmployeeEntity> getAllObjects(){
		return es.getAllObject();
	}
	
	@PutMapping(value="/updatebyid")
	public String updateById(@RequestBody EmployeeEntity e) {
		return es.updateById(e);
	}
	@PatchMapping(value="/updatename/{a}")
	public String updateName(@RequestBody EmployeeEntity e,@PathVariable int a) {
		return es.updateName(e,a);
	}
	//Queries methods
	@GetMapping(value="getbetweensalusingnative/{a}/{b}")
	public List<EmployeeEntity> getBetweenSalUsingNative(@PathVariable int a,@PathVariable int b){
		return es.getBetweenSalUsingNative(a, b);
	}
	@GetMapping(value="getbetweensalusingjquery/{a}/{b}")
    public List<EmployeeEntity> getBetweenSalUsingJquery(@PathVariable int a,@PathVariable int b){
		return es.getBetweenSalUsingJquery(a, b);
	}
	//
	@GetMapping(value="getempdetailbyname/{a}")
	public EmployeeEntity getEmpDetailByName(@PathVariable String a) {
		return es.getEmpDetailByName(a);
	}
	@GetMapping(value="getobjectbystartingletter")
	public List<EmployeeEntity> getObjectByStartingLetter(){
		return es.getObjectByStartingLetter();
	}
	@GetMapping(value="getobjectbyletterusingparameter/{a}")
	public List<EmployeeEntity> getObjectByStartingLetterUsingParameter(@PathVariable char a){
		return es.getObjectByStartingLetterUsingParameter(a);
	}
	@GetMapping(value="getmaxsalwithobject")
	public EmployeeEntity getMaxSalWithObject() {
		return es.getMaxSalWithObject();
	}
	@GetMapping(value="getobjectorderofsalarydesc")
	public List<EmployeeEntity> getObjectOrderOfSalaryDesc(){
		return es.getObjectOrderOfSalaryDesc();
	}
	@GetMapping(value="getsecondmaxsalwithobject")
	public EmployeeEntity getSecondMaxSalWithObject() {
		return es.getSecondMaxSalWithObject();
	}
	@GetMapping(value="getgroupofnameusingendswith/{x}")
	public Long getGroupOfNameUsingEndsWith(@PathVariable String x){
		return es.getGroupOfNameUsingEndsWith(x);
	}
	@GetMapping(value="getsumofsalaryusinglikeoperator")
	public int getSumOfSalaryUsingLikeOperator() {
		return es.getSumOfSalaryUsingLikeOperator();
	}
	@GetMapping(value="getgroupofgenderwithavgsal")
	public List<Object[]> getGroupOfGenderWithAvgSal(){
		return es.getGroupOfGenderWithAvgSal();
	}
	
	
}
