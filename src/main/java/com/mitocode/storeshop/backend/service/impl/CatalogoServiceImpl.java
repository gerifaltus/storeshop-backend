package com.mitocode.storeshop.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.storeshop.backend.models.Catalogo;
import com.mitocode.storeshop.backend.repository.CatalogoRepository;
import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.service.CatalogoService;

@Service
public class CatalogoServiceImpl extends GenericServiceImpl<Catalogo, Integer> implements CatalogoService {

	@Autowired
	private CatalogoRepository repo;
	
	@Override
	protected GenericRepository<Catalogo, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Catalogo registrar(Catalogo c) throws Exception {	
		return repo.save(c);
	}

	@Override
	public Catalogo modificar(Catalogo p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<Catalogo> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Catalogo listarPorId(Integer id) throws Exception {
		Optional<Catalogo> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Catalogo();
		
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}

}
