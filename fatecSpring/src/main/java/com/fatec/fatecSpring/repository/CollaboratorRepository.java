package com.fatec.fatecSpring.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
	public Optional<Collaborator> findById(Long id);
	public Collaborator findByName(String name);
	
	public List<Department> findByDepartment(Department department);
	
	@Query("Select c FROM Collaborator c")
	public Collection<Collaborator> getAll();
	
	@Query("SELECT c FROM Collaborator c WHERE c.id_collaborator = ?1 ")
	public Collaborator buscarPorId(Integer id);
	
}
