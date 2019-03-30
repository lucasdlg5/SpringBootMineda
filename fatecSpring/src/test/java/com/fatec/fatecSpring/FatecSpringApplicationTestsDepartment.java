package com.fatec.fatecSpring;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
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
import com.fatec.fatecSpring.service.DepartmentImplements;



@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
@Transactional
public class FatecSpringApplicationTestsDepartment {

	/*
	private static final String NAME_COLLABORATOR = "Gutinho da Silva";
	private static final Integer AGE_COLLABORATOR = 21;
	private static final String CPF_COLLABORATOR = "33333333333";
	private static final String NAME_DEPARTMENT = "HUMAN RESOURCES";
	private static final String DESCRIPTION = "FOR HUMAN PURPOSES";
	private static final String OBSERVATION = "HR";
	Department dep = new Department (NAME_DEPARTMENT, DESCRIPTION, OBSERVATION);
	Collaborator col1 = new Collaborator(NAME_COLLABORATOR, AGE_COLLABORATOR, CPF_COLLABORATOR, dep);
	 */
	
	@Autowired
	private CollaboratorImplements collImp;
	@Autowired
	private CollaboratorRepository collRep;
	@Autowired
	private DepartmentImplements deptoImp;
	
	
	//Department
	
	@Autowired
	private DepartmentImplements deptImp2;
	
	@Autowired
	private DepartmentRepository deptRep;
	Department dept1 =  new Department("venda", "aqui vende", "vende pra caramba");
	
	
	
	Collaborator col2 = new Collaborator("Kewinho Acoxambers", 20, "22222222222", new Department ("Venda", "FOR RESEARCHES", "BI"));
	Collaborator col1 = new Collaborator("Gutinho da Silva", 21, "11111111111", new Department ("Venda", "FOR HUMAN PURPOSES", "HR"));
	Collaborator col3 = new Collaborator("Gusta Zangast", 22, "33333333333", new Department ("PRO PLAYER", "AT LEAGUE OF CANCER", "LOLZINHO"));
	Collaborator col4 = new Collaborator("Jonta Sóisso", 22, "44444444444", new Department ("VALGA", "BUNDO", "VAGABUNDO"));
	
	@Before public void populateDatabase(){
		collRep.save(col1);
		collRep.save(col2);
		collRep.save(col3);
		collRep.save(col4);
		deptRep.save(dept1);
		
		
	}
	
	@Test
	public void findByName() {
		assertEquals(dept1.getName(), deptImp2.findByName("venda").getName());
	}
	
	@Test
	public void findByObservation() {
		assertEquals(dept1.getObservation(), deptImp2.findByObservation("aqui vende").getObservation());

	}
	
	@Test
	public void findCollaboratorByDepartment() {
		assertEquals(2, deptImp2.findCollaboratorByDepartment("Vende").size(),0);

	}

	
	@After public void truncateDatabase(){
		deptoImp.truncateDatabaseDepartment();
		collImp.truncateDatabaseCollaborator();
	}
	
	
	
}

