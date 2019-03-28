package com.fatec.fatecSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.repository.CollaboratorRepository;
import com.fatec.fatecSpring.repository.DepartmentRepository;

@Service("DepartmentService")
public class DepartmentImplements implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRep;
	CollaboratorRepository collabRep;
	
	public Department findByObservation(String phrase) {
		return departmentRep.findByObservation(phrase);
	}
	
	public Department findByName(String name) {
		return departmentRep.findByName(name);
	}
	
	public List<Department> findByNameList(String name){
		return departmentRep.findByNameList(String name);
	}
	
	
}
