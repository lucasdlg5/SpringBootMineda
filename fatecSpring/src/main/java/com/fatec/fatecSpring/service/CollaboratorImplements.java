package com.fatec.fatecSpring.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.repository.CollaboratorRepository;



@Service("CollaboratorService")
public class CollaboratorImplements implements CollaboratorService {
	
	@Autowired
	CollaboratorRepository collaboratorRep;
	
	public Collaborator buscarPorId(Integer id) {
		return collaboratorRep.buscarPorId(id);
	}

	@Transactional
	public Collaborator findByCpf(String cpfv) {
		return collaboratorRep.findByCpf(cpfv);
	} 
	
	
	public Collaborator findByName(String name) {
		return collaboratorRep.findByName(name);
	}
	
	public Integer findByAge(Integer age) {
		return collaboratorRep.findByAge(age);
	}

	public List<Department> findByDepartment(Department department){
		return collaboratorRep.findByDepartment(department);
	}

	
	// other methods, @Autowiring, etc

    @Override
    @Transactional
    public void truncateDatabaseCollaborator() {
    	collaboratorRep.truncateDatabaseCollaborator();
    }


	@Override
	public Collection<Collaborator> getAll() {
		return collaboratorRep.getAll();
	}

	@Override
	public Collaborator save(Collaborator collaborator) {
		Collaborator col = collaboratorRep.findByCpf(collaborator.getCpf());
		if (col == null) return collaboratorRep.save(collaborator);
		return null;
		
	}
	

	
}
