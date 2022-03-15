package com.fuctura.cliente.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fuctura.cliente.models.Cliente;
import com.fuctura.cliente.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class ClienteController {
		
	@Autowired
	ClienteService service;
	
	@GetMapping("/findAll")
	@Operation(summary="Lista todos clientes")
	public List<Cliente> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value ="/{id}")
	public Cliente findId(@PathVariable Long id) {
		return service.findId(id);
	}
	
	@PostMapping("/post")
	public Cliente post(@Valid @RequestBody Cliente cliente) {
		return service.post(cliente);
	}
	
	@DeleteMapping("/delete")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	@PutMapping("/put")
	public void put(@RequestBody Cliente cliente) {
		service.put(cliente);
	}
	
}
