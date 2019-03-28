package com.fatec.fatecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator, Long> {
	
	//@Query("SELECT * FROM collaborator WHERE name LIKE '%:name%'")
	//public List<Collaborator> findByNameCollaborator(@Param(":name") String name);
	
	@Modifying
    @Query(value = "truncate table collaborator",nativeQuery = true)
	void truncateDatabaseCollaborator();
	
	
	
	public Collaborator findByCpf(String cpfv);
	
	public Collaborator findByName(String name);
	
	public Collaborator findByAge(Integer age);
	
	public List<Department> findByDepartment(Department department);
	
}
