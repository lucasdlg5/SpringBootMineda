	package com.fatec.fatecSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Collaborator")
public class Collaborator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_collaborator;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "cpf")
	private String cpf;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL/*, targetEntity = Department.class*/)
	@JoinColumn(name="department_id")
	private Department department;


	public Integer getId_collaborator() {
		return id_collaborator;
	}

	public void setId_collaborator(Integer id_collaborator) {
		this.id_collaborator = id_collaborator;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Collaborator(String NAME, Integer AGE, String CPF, Department department) {
		this.name = NAME;
		this.age = AGE;
		this.cpf = CPF;
		this.department = department;
	
	}

	public Collaborator() {
		
	}

	public Integer getID_COLLABORATOR() {
		return id_collaborator;
	}

	public void setID_COLLABORATOR(Integer id_coll) {
		id_collaborator = id_coll;
	}

	public String getName() {
		return name;
	}

	public void setName(String namev) {
		this.name = namev;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer agev) {
		this.age = agev;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfv) {
		this.cpf = cpfv;
	}


}
