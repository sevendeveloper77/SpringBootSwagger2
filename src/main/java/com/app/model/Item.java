package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="itemstab")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer itemid;
	@Column(name="code")
	private String icode;
	@Column(name="cost")
	private Double icost;
}
