package com.mitocode.storeshop.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_catalogo_detalle")
public class CatalogoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_catalogo", nullable = false, foreignKey = @ForeignKey(name = "FK_catalogo_detalle_catalogo"))
	private Catalogo catalogo;
	
	@Column(name = "nombre_detalle", length = 50, nullable = false)
	private String nombreDetalle;
}
