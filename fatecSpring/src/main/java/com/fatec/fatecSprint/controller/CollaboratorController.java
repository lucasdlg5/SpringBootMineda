package com.fatec.fatecSprint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.service.CollaboratorService;
import com.fatec.fatecSprint.view.View;

@RestController
@RequestMapping(value = "/collaborator")
public class CollaboratorController {

	//Para rodar o JSON, usar o comando dentro do diretorio POM.XML dentro do terminal
	//mvn spring-boot:run
	//Realizar os testes usando Postman ou similar
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	/*// www.[...].com/collaborator/get/"Antonio"
	@RequestMapping (value = "/get/{name}")
	@JsonView({View.collaboratorName.class})
	public ResponseEntity<Collaborator> pesquisarNomeCollaborator (@PathVariable("name") String name){
		Collaborator col = collaboratorService.findByName(name);
		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( collaboratorService.findByName(name), HttpStatus.OK);
	}*/
	
	
	
	
	// www.[...].com/collaborator/getByCpf?cpf="teste"
	@RequestMapping (value = "/getbycpf")
	//@JsonView({View.collaboratorCpf.class})
	public ResponseEntity<Collaborator> getCollaboratorByCpf (@RequestParam (value="cpf", defaultValue="1") String cpf){
		System.out.println(cpf);
		Collaborator col = collaboratorService.findByCpf(cpf);
		//System.out.println(col.getName());

		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( col, HttpStatus.OK);
	}
	
	
	/*
	
	@RequestMapping (value = "/getAll")
	@JsonView({View.All.class})
	public ResponseEntity<Collection<Collaborator>> getAllCollaborator(){
		return new ResponseEntity<Collection<Collaborator>>(collaboratorService.getAll(), HttpStatus.OK);
	}
	*/
	
}
