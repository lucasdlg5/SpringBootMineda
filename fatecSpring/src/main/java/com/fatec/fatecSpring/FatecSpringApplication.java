


package com.fatec.fatecSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.repository.CollaboratorRepository;
import com.fatec.fatecSpring.repository.DepartmentRepository;
import com.fatec.fatecSpring.service.CollaboratorService;



//Classe que pode ser usada para inicializar e iniciar um aplicativo Spring a partir 
//de um método principal Java.
@SpringBootApplication
public class FatecSpringApplication implements CommandLineRunner {
	/*
	@Autowired
	private CollaboratorRepository collRep;
	@Autowired
	private DepartmentRepository deptoRep;
	
	private static final String NAME_COLLABORATOR = "Gutinho da Silva";
	private static final Integer AGE_COLLABORATOR = 21;
	private static final String CPF_COLLABORATOR = "33333333333";
	private static final String NAME_DEPARTMENT = "HUMAN RESOURCES";
	private static final String DESCRIPTION = "FOR HUMAN PURPOSES";
	private static final String OBSERVATION = "HR";
	*/
	public static void main(String[] args) {
		SpringApplication.run(FatecSpringApplication.class, args);
	}

	@Autowired
	CollaboratorService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Collaborator col1 = new Collaborator(NAME_COLLABORATOR, AGE_COLLABORATOR, CPF_COLLABORATOR, new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION));
		//Collaborator col1 = new Collaborator("Gutinho da Silva", 21, "11111111111", new Department ("HUMAN RESOURCES", "FOR HUMAN PURPOSES", "HR"));
		//collRep.save(col1);
		
		//Department dep = new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION);
		//deptoRep.save(dep);
		//System.out.println("Nome: "+deptoRep.findByName(NAME_DEPARTMENT).getName());
		//System.out.println("Description: "+deptoRep.findByDescription(DESCRIPTION).getDescription());
		//System.out.println("Observation: "+deptoRep.findByObservation(OBSERVATION).getObservation());


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
