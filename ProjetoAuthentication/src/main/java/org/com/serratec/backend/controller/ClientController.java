package org.com.serratec.backend.controller;

import java.util.List;

import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
	
	@Autowired
	ClientService service;
	
	@GetMapping("/client")
	public List<ClientEntity> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/client/{id}")
	public ClientEntity findById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/create")
	public ClientEntity create(@RequestBody ClientEntity entity) {
		return service.create(entity);
	}

}
