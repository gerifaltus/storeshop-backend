package com.mitocode.storeshop.backend.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.storeshop.backend.exception.ModeloNotFoundException;
import com.mitocode.storeshop.backend.models.CatalogoDetalle;
import com.mitocode.storeshop.backend.service.CatalogoDetalleService;


@RestController
@RequestMapping("/catalogosDetalle")
public class CatalogoDetalleController {

	@Autowired
	private CatalogoDetalleService service;
	
	
	@GetMapping
	public ResponseEntity<List<CatalogoDetalle>> listar() throws Exception {
		List<CatalogoDetalle> lista = service.listar();
		return new ResponseEntity<List<CatalogoDetalle>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CatalogoDetalle> listarPorId(@PathVariable("id") Integer id) throws Exception {
		CatalogoDetalle obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<CatalogoDetalle>(obj, HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<CatalogoDetalle> registrar(@Valid @RequestBody CatalogoDetalle p) throws Exception{
		CatalogoDetalle obj = service.registrar(p);
		
		// localhost:8080/pacientes/{2}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<CatalogoDetalle> modificar(@Valid @RequestBody CatalogoDetalle p) throws Exception{
		CatalogoDetalle obj = service.modificar(p);
		
		return new ResponseEntity<CatalogoDetalle>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		CatalogoDetalle obj = service.listarPorId(id);
		
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
