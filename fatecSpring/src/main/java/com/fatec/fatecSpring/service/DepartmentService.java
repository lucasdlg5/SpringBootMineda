package com.fatec.fatecSpring.service;


import java.util.Collection;
import java.util.List;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;

public interface DepartmentService {
	
	public Department findByObservation(String phrase);
	public Department findByName(String name);
	public void truncateDatabaseDepartment();
	public Collection<Department> geAll();
	
}
