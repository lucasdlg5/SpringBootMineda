package com.fatec.fatecSpring.service;

import java.util.Collection;
import java.util.List;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;



public interface CollaboratorService  {
	
	public List<Collaborator> findByNameOrCpfOrAge(String name, Integer age, String cpf );

	public Collaborator findByCpf(String cpfv);
	
	public Collaborator findByName(String name);
	
	public Integer findByAge(Integer age);
	
	public List<Department> findByDepartment(Department department);
	
	public void truncateDatabaseCollaborator();

	public Collection<Collaborator> getAll();


	public Collaborator buscarPorId(Integer id);

	Collaborator save(Collaborator collaborator);
}
