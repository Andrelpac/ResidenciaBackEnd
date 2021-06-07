package org.com.serratec.backend.ProjetoCrud04.service;

import java.util.ArrayList;
import java.util.List;

import org.com.serratec.backend.ProjetoCrud04.dto.AutorDTO;
import org.com.serratec.backend.ProjetoCrud04.entity.AddressEntity;
import org.com.serratec.backend.ProjetoCrud04.entity.AutorEntity;
import org.com.serratec.backend.ProjetoCrud04.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

	@Autowired
	AutorRepository repository;
	
	@Autowired
	AddressService addressService;
	
	public AutorEntity getById(Integer id) {
		return null;
	}
	
	public List<AutorEntity> getAll(){
		return repository.findAll();
	}
	
	public AutorEntity create(AutorDTO dto) {
		AutorEntity entity = new AutorEntity();
		entity.setNome(dto.getNome());
		AutorEntity autorSaved = repository.save(entity);
		addressService.create(dto.getCep(), autorSaved);
		return autorSaved;
	}

}
