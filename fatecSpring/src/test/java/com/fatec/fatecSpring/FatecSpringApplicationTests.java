package com.fatec.fatecSpring;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.repository.CollaboratorRepository;
import com.fatec.fatecSpring.repository.DepartmentRepository;
import com.fatec.fatecSpring.service.CollaboratorImplements;
import com.fatec.fatecSpring.service.CollaboratorService;



@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
@Transactional
public class FatecSpringApplicationTests {

	private static final String NAME_COLLABORATOR = "Gutinho da Silva";
	private static final Integer AGE_COLLABORATOR = 21;
	private static final String CPF_COLLABORATOR = "33333333333";
	private static final String NAME_DEPARTMENT = "HUMAN RESOURCES";
	private static final String DESCRIPTION = "FOR HUMAN PURPOSES";
	private static final String OBSERVATION = "HR";
	Department dep = new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION);
	Collaborator col1 = new Collaborator(NAME_COLLABORATOR, AGE_COLLABORATOR, CPF_COLLABORATOR, dep);
	@Autowired
	private CollaboratorRepository CollaboratorRepo;
	@Autowired
	private DepartmentRepository deptoRep;
	@Autowired
	private CollaboratorImplements collImp;
	
	@Test
	public void procuraCollaboratorPorCpf() {
		
		Collaborator col1 = new Collaborator(NAME_COLLABORATOR, AGE_COLLABORATOR, CPF_COLLABORATOR, new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION));
		CollaboratorRepo.save(col1);		
		assertEquals(collImp.findByCpf(CPF_COLLABORATOR).getCpf(),col1.getCpf());
	}	
	
}

