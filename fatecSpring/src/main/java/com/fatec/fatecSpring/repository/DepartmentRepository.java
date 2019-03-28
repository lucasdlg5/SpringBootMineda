package com.fatec.fatecSpring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
	
	//@Query ("SELECT * FROM department WHERE name like '%:name%'")
	//public List<Department> findByDepartmentName(@Param (":name") String name);
	
	public Department findByObservation(String phrase);

	public Department findByName(String name);
	public List<Collaborator> findByDepartment(Department department);
	public List<Department> findByNameList(String name);
	
	@Modifying
    @Query(value = "truncate table department",nativeQuery = true)
	void truncateDatabaseDepartment();
}
