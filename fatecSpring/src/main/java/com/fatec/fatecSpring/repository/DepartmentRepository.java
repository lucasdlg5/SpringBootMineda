package com.fatec.fatecSpring.repository;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{
	
	
	
	
	
	@Modifying
    @Query(value = "truncate table department",nativeQuery = true)
	void truncateDatabaseDepartment();

	@Query ("SELECT d FROM Department d where d.observation like %?1%")
	public Department findByObservation(String phrase);
	
	@Query ("SELECT d FROM Department d where d.description like %?1%")
	public Department findByDescription(String description);

	public Department findByName(String name);
	

	
	@Query("Select d from Department d")
	public Collection<Department> getAll();
	
	
	@Query("SELECT d FROM Department d WHERE d.id_department = ?1 ")
	public Department buscarPorId(Integer id);
	
	//public Department salvar(Department department);
}
