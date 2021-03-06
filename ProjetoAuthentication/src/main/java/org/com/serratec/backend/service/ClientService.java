package org.com.serratec.backend.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.com.serratec.backend.entity.ClientDTO;
import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ClientService {

	@Autowired
	ClientRepository repository;

	@Autowired
	BCryptPasswordEncoder bCrypt;
	
	@Autowired
	ImageService imageService;

	public ClientDTO getImage(ClientEntity entity) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("client/{clientId}/image")
				.buildAndExpand(entity.getId()).toUri();
		ClientDTO client = new ClientDTO();
		client.setCpf(entity.getCpf());
		client.setNome(entity.getNome());
		client.setUsername(entity.getUsername());
		client.setUrl(uri.toString());
		return client;
	}

	public List<ClientEntity> getAll() {
		return repository.findAll();
	}

	public ClientEntity getById(Long id) {
		Optional<ClientEntity> opt = repository.findById(id);
		return opt.get();
	}

	public ClientDTO create(ClientEntity entity, MultipartFile file) throws IOException {
		entity.setSenha(bCrypt.encode(entity.getSenha()));
		ClientEntity entitySaved = repository.save(entity);
		imageService.create(entitySaved, file);
		return getImage(entitySaved);
	}
}
