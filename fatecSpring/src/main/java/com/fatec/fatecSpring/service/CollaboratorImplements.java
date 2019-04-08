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
	
	public Collaborator buscarPorId(Long id) {
		Optional<Collaborator> coll = collaboratorRep.findById(id);
		if(coll.isPresent()) {
			return coll.get();
		}
		return null;
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

//	@Override
//	@Transactional
//	public Collaborator salvar(Collaborator collaborator) {
//		Collaborator coll= collaboratorRep.findByName(collaborator.getName());
//		if(coll == null) {
//			collaboratorRep.save(collaborator);
//			return collaborator;
//			
//		}
//		return null;
//	}

	
}
