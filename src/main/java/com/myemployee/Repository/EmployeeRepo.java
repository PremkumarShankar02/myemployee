package com.myemployee.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myemployee.Entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {
	//native query
	@Query(value="select * from employee_details where salary between ? and ?",nativeQuery = true)
	public List<EmployeeEntity> getBetweenSalUsingNative(int a,int b);
	
	// J query
	//between salary
	@Query(value="select e from EmployeeEntity e where e.salary between :a and :b")
	public List<EmployeeEntity> getBetweenSalUsingJquery(@Param("a") int a,@Param("b") int b);
	
	@Query(value="select e from EmployeeEntity e where e.name=:a")
	public EmployeeEntity getEmpDetailByName(@Param("a") String a);
	//starts with no parameter
	@Query(value="select e from EmployeeEntity e where e.name like 'p%'")
	public List<EmployeeEntity> getObjectByStartingLetter();
	//starts with using parameter
	@Query(value="select e from EmployeeEntity e where e.name like concat(:a,'%')")
	public List<EmployeeEntity> getObjectByStartingLetterUsingParameter(@Param("a") char a);
	//max
	@Query(value="select e from EmployeeEntity e where e.salary=(select max(e.salary) from EmployeeEntity e)")
	public EmployeeEntity getMaxSalWithObject();
	//orderby
	@Query(value="select e from EmployeeEntity e order by e.salary desc")
		public List<EmployeeEntity> getObjectOrderOfSalaryDesc();
	
	//secondmax
	@Query(value="select e from EmployeeEntity e where e.salary=(select max(e.salary) from EmployeeEntity e where e.salary<(select max(e.salary) from EmployeeEntity e))")
	public EmployeeEntity getSecondMaxSalWithObject();
	
	//count
	@Query(value="select count(e.name) from EmployeeEntity e where e.name like concat('%',:x)")
	public Long getGroupOfNameUsingEndsWith(@Param("x") String x);
	
	//Sum 
	@Query(value="select sum(e.salary) from EmployeeEntity e where e.name like 'a%'")
	public int getSumOfSalaryUsingLikeOperator();
	
	//Group by with gender using average salary
	@Query(value="select e.gender,avg(e.salary) from EmployeeEntity e group by e.gender")
	public List<Object[]> getGroupOfGenderWithAvgSal();
}
