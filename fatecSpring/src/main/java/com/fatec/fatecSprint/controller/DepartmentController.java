package com.fatec.fatecSprint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.fatecSpring.service.DepartmentService;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
}
