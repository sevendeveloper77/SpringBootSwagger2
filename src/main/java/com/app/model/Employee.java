package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="empstab")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer eid;
	@Column(name="name")
	private String ename;
	@Column(name="sal")
	private Double esal;
}
