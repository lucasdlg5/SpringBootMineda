package com.fatec.fatecSpring.service;


import java.util.Collection;
import java.util.List;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;

public interface DepartmentService {
	
	public Department findByObservation(String phrase);
	public Department findByName(String name);
	public Department findByDescription (String description);
	public void truncateDatabaseDepartment();
	public Collection<Department> geAll();
	public Department buscarPorId(Integer id);
	public Department save(Department department);
}
