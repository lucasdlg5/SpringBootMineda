package com.fatec.fatecSpring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatec.fatecSpring.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
	
	//@Query ("SELECT * FROM department WHERE name like '%:name%'")
	//public List<Department> findByDepartmentName(@Param (":name") String name);
	
	public Department findByObservation(String phrase);

	

	
}
