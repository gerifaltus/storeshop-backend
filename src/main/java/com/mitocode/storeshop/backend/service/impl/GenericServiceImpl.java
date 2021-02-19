package com.mitocode.storeshop.backend.service.impl;

import java.util.List;

import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.service.GenericService;

public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

	protected abstract GenericRepository<T, ID> getRepo();
	
	@Override
	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {		
		return getRepo().findAll();
	}

	@Override
	public T listarPorId(ID id) throws Exception {
		return getRepo().findById(id).orElse(null);
	}

	@Override
	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
