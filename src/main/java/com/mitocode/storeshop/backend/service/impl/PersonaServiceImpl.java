package com.mitocode.storeshop.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.storeshop.backend.models.Persona;
import com.mitocode.storeshop.backend.repository.PersonaRepository;
import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.service.PersonaService;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements PersonaService {

	@Autowired
	private PersonaRepository repo;
	
	@Override
	protected GenericRepository<Persona, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Persona registrar(Persona c) throws Exception {	
		return repo.save(c);
	}

	@Override
	public Persona modificar(Persona p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<Persona> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Persona listarPorId(Integer id) throws Exception {
		Optional<Persona> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Persona();
		
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}

}
