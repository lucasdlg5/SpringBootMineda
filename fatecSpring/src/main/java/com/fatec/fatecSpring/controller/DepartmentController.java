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
	 @RequestMapping("/")
     public String home(){
         return "Hello World!";
     }
	private DepartmentService departmentService;
	@RequestMapping (value = "/getName/{name}")
	@JsonView({View.departmentName.class})
	public ResponseEntity<Department> findDepartmentByName(@PathVariable("name") String name){
		Department dept = departmentService.findByName(name);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Department> (departmentService.findByName(name), HttpStatus.OK);
}
	

	@RequestMapping (value = "/getObs/{obs}")
	@JsonView({View.departmentName.class})
	public ResponseEntity<Department> findDepartmentByObs(@PathVariable("obs") String obs){
		Department dept = departmentService.findByName(obs);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Department> (departmentService.findByObservation(obs), HttpStatus.OK);
}
	
	
	@RequestMapping (value = "/getAll")
	@JsonView({View.All.class})
	public ResponseEntity<Collection<Department>> getAllDepartment(){
		return new ResponseEntity<Collection<Department>>(departmentService.geAll(), HttpStatus.OK);
	}
	
	
}