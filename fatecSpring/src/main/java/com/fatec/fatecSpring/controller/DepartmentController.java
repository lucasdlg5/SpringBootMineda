package com.fatec.fatecSpring.controller;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
	 @RequestMapping("/")
	 public String home(){
	     return "Hello World!";
	 }
	 
	 
	 
	@RequestMapping (value = "/getName/{name}")
	@JsonView({View.All.class})
	public ResponseEntity<Department> findDepartmentByName(@PathVariable("name") String name){
		Department dept = departmentService.findByName(name);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<Department> (dept , HttpStatus.OK);
}
	

	@RequestMapping (value = "/getObs/{obs}")
	@JsonView({View.All.class})
	public ResponseEntity<Department> findDepartmentByObs(@PathVariable("obs") String obs){
		Department dept = departmentService.findByObservation(obs);
		if(dept == null) return new ResponseEntity<Department> (HttpStatus.NOT_FOUND);
		return new ResponseEntity<Department> (dept, HttpStatus.OK);
}
	
	
	@RequestMapping (value = "/getAll")
	@JsonView({View.All.class})
	public ResponseEntity<Collection<Department>> getAllDepartment(){
		return new ResponseEntity<Collection<Department>>(departmentService.geAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbyid/{id}")
	 @JsonView({View.All.class})
	 public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Integer id){
		 Department dept = departmentService.buscarPorId(id);
		 if (dept == null) {
			 return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		 }
		 return new ResponseEntity<Department> (dept, HttpStatus.OK);
	 }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.All.class)
	public ResponseEntity<Department> save(@RequestBody Department department, HttpServletRequest request, HttpServletResponse response) {
		department = departmentService.save(department);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/collaborator/getById?id=" + department.getID_DEPARTMENT());
		return new ResponseEntity<Department>(department, HttpStatus.CREATED);
	} 
	
}