package com.fatec.fatecSpring.controller;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.model.Department;
import com.fatec.fatecSpring.service.DepartmentService;
import com.fatec.fatecSpring.view.View;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	
	private DepartmentService departmentService;
		
	 @RequestMapping("/")
	 public String home(){
	     return "Hello World!";
	 }
	 
	 
	 
	@RequestMapping (value = "/getName/{name}")
	@JsonView({View.departmentName.class})
	public ResponseEntity<Department> findDepartmentByName(@PathVariable("name") String name){
		System.out.println("Parametro recebido da rota /getName/{name}: "+ name);
		Department dept = departmentService.findByName(name);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		System.out.println(dept.getName());
		return new ResponseEntity<Department> (dept , HttpStatus.OK);
}
	

	@RequestMapping (value = "/getObs/{obs}")
	@JsonView({View.departmentName.class})
	public ResponseEntity<Department> findDepartmentByObs(@PathVariable("obs") String obs){
		System.out.println("Parametro recebido da rota /getObs/{obs}: "+ obs);
		Department dept = departmentService.findByObservation(obs);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		System.out.println(dept.getObservation());
		
		return new ResponseEntity<Department> (dept, HttpStatus.OK);
}
	
	
	@RequestMapping (value = "/getAll")
	@JsonView({View.All.class})
	public ResponseEntity<Collection<Department>> getAllDepartment(){
		return new ResponseEntity<Collection<Department>>(departmentService.geAll(), HttpStatus.OK);
	}
	
	
}