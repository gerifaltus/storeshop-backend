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
@Table(name="tbl_venta_detalle")
public class VentaDetalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5735075310964668771L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_venta", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_venta_venta"))
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable = false, foreignKey = @ForeignKey(name = "fk_detalle_venta_producto"))
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
}
