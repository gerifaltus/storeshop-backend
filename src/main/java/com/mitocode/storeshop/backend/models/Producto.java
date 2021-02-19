package com.mitocode.storeshop.backend.models;

import java.io.Serializable;

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
@Table(name="tbl_producto")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3482261560215343275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="id_marca", nullable = false, foreignKey = @ForeignKey(name="fk_producto_catalogo_detalle"))
	private CatalogoDetalle marca;
}
