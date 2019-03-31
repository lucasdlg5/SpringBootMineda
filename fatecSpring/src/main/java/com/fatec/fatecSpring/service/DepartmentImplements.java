package com.fatec.fatecSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.repository.DepartmentRepository;



@Service("DepartmentService")
public class DepartmentImplements implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRep;
	
	public Department findByObservation(String phrase) {
		return departmentRep.findByObservation(phrase);
	}
	
	public Department findByName(String name) {
		return departmentRep.findByName(name);
	}
	
	
	@Override
    @Transactional
	    public void truncateDatabaseDepartment() {
		departmentRep.truncateDatabaseDepartment();
    }

}
