package com.fatec.fatecSprint.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.service.CollaboratorService;

@RestController
@RequestMapping(value = "/collaborator")
public class CollaboratorController {

	//Para rodar o JSON, usar o comando dentro do diretorio POM.XML dentro do terminal
	//mvn spring-boot:run
	//Realizar os testes usando Postman ou similar
	
	 
	private CollaboratorService collaboratorService;
	
	// www.[...].com/collaborator/get/"Antonio"
	@RequestMapping (value = "/get/{name}")
	//@JsonView(View.All.class)
	public ResponseEntity<Collaborator> pesquisarNomeCollaborator (@PathVariable("name") String name){
		Collaborator col = collaboratorService.findByName(name);
		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( collaboratorService.findByName(name), HttpStatus.OK);
	}
	
	// www.[...].com/collaborator/getByCpf?cpf="teste"
	@RequestMapping (value = "/getByCpf")
	//@JsonView(View.All.class)
	public ResponseEntity<Collaborator> getCollaboratorByCpf (@RequestParam (value="cpf", defaultValue="1") String cpf){
		Collaborator col = collaboratorService.findByCpf(cpf);
		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( collaboratorService.findByCpf(cpf), HttpStatus.OK);
	}
	
	@RequestMapping (value = "/getAll")
	//@JsonView(View.Alternative.Class)
	public ResponseEntity<Collection<Collaborator>> getAllCollaborator(){
		return new ResponseEntity<Collection<Collaborator>>(collaboratorService.getAll(), HttpStatus.OK);
	}
	
	
}
