package org.com.serratec.backend.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.entity.Imagem;
import org.com.serratec.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	@Autowired
	private ImageRepository repository;
	
	
	@Transactional
	public Imagem create(ClientEntity entity, MultipartFile file) throws IOException {
		Imagem image = new Imagem();
		image.setName("Imagem");
		image.setMimetype(file.getContentType());
		image.setData(file.getBytes());
		image.setClient(entity);
		return repository.save(image);
	}
	
	@Transactional
	public Imagem getImage(Long id) {
		Imagem client = repository.findByClientId(id);
		return client;

	}
}
