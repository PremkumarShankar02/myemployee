package com.MobileApplication.Repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.MobileApplication.Entity.MobileApplication;



public interface MobileApplicationRepo extends JpaRepository<MobileApplication, Integer> {
	
	@Query(value="select * from mobileapplication_details where user=(select max(user) from mobileapplication_details where user<(select max(user) from mobileapplication_details))",nativeQuery = true)
	public MobileApplication getMaxObject();
	
	@Query(value="select * from mobileapplication_details where user>=? && user<=?",nativeQuery = true)
	public List<MobileApplication> getBetweenObjectUsingOperator(int a,int b);
	
	@Query(value="select * from mobileapplication_details where name=?",nativeQuery = true)
	public List<MobileApplication> getObjectByName(String n);
	
	@Query(value="select m from MobileApplication m where m.id=:a")
	public List<MobileApplication> getObjectById(@Param("a") int a);
	
	@Query(value="select * from mobileapplication_details where name like 'n%'",nativeQuery = true)
	public List<MobileApplication> getObjectUsingStartsWith();

}