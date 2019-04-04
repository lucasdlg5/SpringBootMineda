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



@EnableAutoConfiguration
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
	private static final String OBSERVATION = "HR";*/
	
	public static void main(String[] args) {
		SpringApplication.run(FatecSpringApplication.class, args);
	}

	/*@Autowired
	CollaboratorService service;
	*/
	@Override
	public void run(String... args) throws Exception {
	/*	
	//Department dep = new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION);
	Collaborator col1 = new Collaborator(NAME_COLLABORATOR, AGE_COLLABORATOR, CPF_COLLABORATOR, new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION));
	collRep.save(col1);
	*/
		//Collaborator col1 = new Collaborator("Gutinho da Silva", 21, "11111111111", new Department ("HUMAN RESOURCES", "FOR HUMAN PURPOSES", "HR"));
		
		//System.out.println(service.findByCpf("333333").getName());
		
		
	}

}
