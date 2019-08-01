package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="custstab")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer cid;
	@Column(name="name")
	private String cname;
	@Column(name="servid")
	private String serviceId;
	@Column(name="mode")
	private String mode;
}
