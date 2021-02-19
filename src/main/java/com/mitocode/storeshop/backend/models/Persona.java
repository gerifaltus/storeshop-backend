package com.mitocode.storeshop.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_persona")
public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8327921644449616330L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 3, message = "{persona.nombres.size}")
	@Column(name = "nombres", length = 50, nullable = false)
	private String nombres;
	
	@Size(min = 3, message = "{persona.nombres.size}")
	@Column(name = "apellidos", length = 100, nullable = false)
	private String apellidos;
	
}
