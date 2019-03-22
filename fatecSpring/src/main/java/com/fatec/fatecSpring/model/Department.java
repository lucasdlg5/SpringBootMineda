package com.fatec.fatecSpring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {
	
	public Department() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_department", columnDefinition="number(10) default '0'")
	private Integer id_department;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "observation")
	private String observation;
	
	@OneToMany (mappedBy = "department")
	private List<Collaborator> departamentoColaborador = new ArrayList<Collaborator>();
	
	public Department(String NAME, String DESCRIPTION, String OBSERVATION) {
		this.name = NAME;
		this.description = DESCRIPTION;
		this.observation = OBSERVATION;
	}

	public String getDESCRIPTION() {
		return description;
	}

	public Integer getID_DEPARTMENT() {
		return id_department;
	}

	public void setID_DEPARTMENT(Integer iD_DEPARTMENT) {
		id_department = iD_DEPARTMENT;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<Collaborator> getDepartamentoColaborador() {
		return departamentoColaborador;
	}

	public void setDepartamentoColaborador(List<Collaborator> departamentoColaborador) {
		this.departamentoColaborador = departamentoColaborador;
	}

	
}
