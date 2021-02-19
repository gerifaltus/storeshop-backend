package com.mitocode.storeshop.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.storeshop.backend.models.Producto;
import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.repository.ProductoRepository;
import com.mitocode.storeshop.backend.service.ProductoService;

@Service
public class ProductoServiceImpl extends GenericServiceImpl<Producto, Integer> implements ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	@Override
	protected GenericRepository<Producto, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Producto registrar(Producto c) throws Exception {	
		return repo.save(c);
	}

	@Override
	public Producto modificar(Producto p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<Producto> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Producto listarPorId(Integer id) throws Exception {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
		
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}

}
