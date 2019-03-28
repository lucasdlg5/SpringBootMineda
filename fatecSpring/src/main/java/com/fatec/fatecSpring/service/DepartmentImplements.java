package com.fatec.fatecSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.repository.DepartmentRepository;



@Service("DepartmentService")
public class DepartmentImplements implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRep;
	
	public Department findByObservation(String phrase) {
		return departmentRep.findByObservation(phrase);
	}
}
