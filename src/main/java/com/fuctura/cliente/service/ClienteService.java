package com.fuctura.cliente.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fuctura.cliente.models.Cliente;
import com.fuctura.cliente.repository.ClienteRepository;

@Service
public class ClienteService {
		
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<Cliente> findAll(){
		return repository.findAll(); 
	}
	
	public Cliente findId(@PathVariable Long id) {
		return this.repository.findById(id).get();
	}
	
	public Cliente post( @RequestBody Cliente cliente) {
		Cliente cli = modelMapper.map(cliente, Cliente.class);
		return repository.save(cliente);
	}
	
	public Cliente put(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	public void delete( Long id) {
		 repository.deleteById(id);
	}
	
	
}
