package com.fatec.fatecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator, Long> {
	
	@Query("SELECT count(c) FROM Collaborator c WHERE c.age = ?1 ")
	public Integer findByAge(Integer age );
	
	@Modifying
    @Query(value = "truncate table collaborator",nativeQuery = true)
	void truncateDatabaseCollaborator();
	
	public Collaborator findByCpf(String cpfv);
	
	public Collaborator findByName(String name);
	
	public List<Department> findByDepartment(Department department);
	
}
