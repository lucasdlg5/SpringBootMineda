package com.fatec.fatecSpring.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fatec.fatecSpring.model.Collaborator;
import com.fatec.fatecSpring.service.CollaboratorService;
import com.fatec.fatecSpring.view.View;


@RestController
@RequestMapping(value = "/collaborator")
public class CollaboratorController {

	//Para rodar o JSON, usar o comando dentro do diretorio POM.XML dentro do terminal
	//mvn spring-boot:run
	//Realizar os testes usando Postman ou similar
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	// www.[...].com/collaborator/get/"Antonio"
	@RequestMapping (value = "/get/{name}")
	@JsonView({View.All.class})
	public ResponseEntity<Collaborator> pesquisarNomeCollaborator (@PathVariable("name") String name){
		Collaborator col = collaboratorService.findByName(name);
		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( col, HttpStatus.OK);
	}
	
	
	
	
	// www.[...].com/collaborator/getByCpf?cpf="teste"
	@RequestMapping (value = "/getbycpf")
	@JsonView({View.All.class})
	public ResponseEntity<Collaborator> getCollaboratorByCpf (@RequestParam (value="cpf", defaultValue="1") String cpf){
		Collaborator col = collaboratorService.findByCpf(cpf);
		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( col, HttpStatus.OK);
	}
	
	
	@RequestMapping (value = "/getbynameorageorcpf")
	@JsonView({View.Id.class})
	public ResponseEntity<Collection<Collaborator>> findByNameOrCpfOrAge (@RequestParam (value="name", defaultValue="0") String name, @RequestParam (value="age", defaultValue="0") Integer age, @RequestParam (value="cpf", defaultValue="0") String cpf){
		return new ResponseEntity<Collection<Collaborator>>(collaboratorService.findByNameOrCpfOrAge(name, age, cpf), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getbyid/{id}")
	@JsonView({View.All.class})
	public ResponseEntity<Collaborator> getCollaboratorById(@PathVariable("id") Integer id){
		Collaborator col = collaboratorService.buscarPorId(id);
		if (col == null) {
			return new ResponseEntity<Collaborator>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collaborator> ( col, HttpStatus.OK);
	}
	
	
	@RequestMapping (value = "/getAll")
	@JsonView({View.All.class})
	public ResponseEntity<Collection<Collaborator>> getAllCollaborator(){
		return new ResponseEntity<Collection<Collaborator>>(collaboratorService.getAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@JsonView(View.All.class)
	public ResponseEntity<Collaborator> save(@RequestBody Collaborator collaborator, HttpServletRequest request, HttpServletResponse response) {
		collaborator = collaboratorService.save(collaborator);
		//if (collaborator == null) return new ResponseEntity<Collaborator>(collaborator, HttpStatus.INTERNAL_SERVER_ERROR);
		response.addHeader("Location", request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/collaborator/getById?id=" + collaborator.getId_collaborator());
		return new ResponseEntity<Collaborator>(collaborator, HttpStatus.CREATED);
	} 
}