package com.mitocode.storeshop.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.storeshop.backend.models.VentaDetalle;
import com.mitocode.storeshop.backend.repository.GenericRepository;
import com.mitocode.storeshop.backend.repository.VentaDetalleRepository;
import com.mitocode.storeshop.backend.service.VentaDetalleService;

@Service
public class VentaDetalleServiceImpl extends GenericServiceImpl<VentaDetalle, Integer> implements VentaDetalleService {

	@Autowired
	private VentaDetalleRepository repo;
	
	@Override
	protected GenericRepository<VentaDetalle, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public VentaDetalle registrar(VentaDetalle c) throws Exception {	
		return repo.save(c);
	}

	@Override
	public VentaDetalle modificar(VentaDetalle p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<VentaDetalle> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public VentaDetalle listarPorId(Integer id) throws Exception {
		Optional<VentaDetalle> op = repo.findById(id);
		return op.isPresent() ? op.get() : new VentaDetalle();
		
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}

}
