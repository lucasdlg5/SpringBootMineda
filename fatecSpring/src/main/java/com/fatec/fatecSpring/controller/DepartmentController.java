package com.fatec.fatecSpring.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping (value = "/get/{name}")
	@JsonView({View.collaboratorName.class})
	public ResponseEntity<Department> findDepartmentByName(@PathVariable("name") String name){
		Department dept = departmentService.findByName(name);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Department> (departmentService.findByName(name), HttpStatus.OK);
}
	
	
	@RequestMapping (value = "/get/{obs}")
	@JsonView({View.collaboratorName.class})
	public ResponseEntity<Department> findDepartmentByObservation(@PathVariable("obs") String obs){
		Department dept = departmentService.findByObservation(obs);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Department> (departmentService.findByName(obs), HttpStatus.OK);
}
	@RequestMapping (value = "getAll")
	@JsonView({View.All.class})
	public ResponseEntity<Collection<Department>> getCollaborator(){
		return new ResponseEntity<Collection<Department>>(departmentService.getAll(), HttpStatus.OK);
}	

}