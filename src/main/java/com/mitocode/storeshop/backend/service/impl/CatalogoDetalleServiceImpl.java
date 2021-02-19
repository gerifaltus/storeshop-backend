package com.mitocode.storeshop.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.storeshop.backend.models.CatalogoDetalle;
import com.mitocode.storeshop.backend.repository.CatalogoDetalleRepository;
import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.service.CatalogoDetalleService;

@Service
public class CatalogoDetalleServiceImpl extends GenericServiceImpl<CatalogoDetalle, Integer> implements CatalogoDetalleService {

	@Autowired
	private CatalogoDetalleRepository repo;
	
	@Override
	protected GenericRepository<CatalogoDetalle, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public CatalogoDetalle registrar(CatalogoDetalle c) throws Exception {	
		return repo.save(c);
	}

	@Override
	public CatalogoDetalle modificar(CatalogoDetalle p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<CatalogoDetalle> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public CatalogoDetalle listarPorId(Integer id) throws Exception {
		Optional<CatalogoDetalle> op = repo.findById(id);
		return op.isPresent() ? op.get() : new CatalogoDetalle();
		
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}

}
