package com.mitocode.storeshop.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.storeshop.backend.models.Venta;
import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.repository.VentaRepository;
import com.mitocode.storeshop.backend.service.VentaService;

@Service
public class VentaServiceImpl extends GenericServiceImpl<Venta, Integer> implements VentaService {

	@Autowired
	private VentaRepository repo;
	
	@Override
	protected GenericRepository<Venta, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Venta registrar(Venta c) throws Exception {	
		return repo.save(c);
	}

	@Override
	public Venta modificar(Venta p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<Venta> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Venta listarPorId(Integer id) throws Exception {
		Optional<Venta> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Venta();
		
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}

}
