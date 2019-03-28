package com.fatec.fatecSpring.service;



public interface DepartmentService {
	
	public Department findByObservation(String phrase);
	public Department findByName(String name);
	public List<Department> findByNameList(String name);
	
	
}
