package com.fatec.fatecSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.fatecSpring.model.Collaborator;

@Repository
public interface CollaboratorRepository extends CrudRepository<Collaborator, Long> {
	
	//@Query("SELECT * FROM collaborator WHERE name LIKE '%:name%'")
	//public List<Collaborator> findByNameCollaborator(@Param(":name") String name);
	
	
	public Collaborator findByCpf(String cpfv);
}
