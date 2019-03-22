package com.fatec.fatecSpring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.repository.CollaboratorRepository;


@Service("CollaboratorService")
public class CollaboratorImplements implements CollaboratorService {
	
	@Autowired
	CollaboratorRepository collaboratorRep;
	
	@Transactional
	public Collaborator findByCpf(String cpfv) {
		return collaboratorRep.findByCpf(cpfv);
	
	}



	
}
