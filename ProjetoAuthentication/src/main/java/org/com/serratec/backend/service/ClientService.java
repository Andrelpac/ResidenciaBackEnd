package org.com.serratec.backend.service;

import java.util.List;
import java.util.Optional;

import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	public List<ClientEntity> getAll(){
		return repository.findAll();
	}
	
	public ClientEntity getById(Long id) {
		Optional<ClientEntity> opt = repository.findById(id);
		return opt.get();
	}
	
	public ClientEntity create(ClientEntity entity) {
		entity.setSenha(bCrypt.encode(entity.getSenha()));
		return repository.save(entity);
	}
}
