package org.com.serratec.backend.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.entity.ImageEntity;
import org.com.serratec.backend.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	
	@Autowired
	ImageRepository repository;
	
	@Transactional
	public ImageEntity create(ClientEntity entity, MultipartFile file) throws IOException {
		ImageEntity image = new ImageEntity();
		image.setClient(entity);
		image.setData(file.getBytes());
		image.setMimeType(file.getContentType());
		image.setNome("Imagem");
		return repository.save(image);
	}
	
	@Transactional
	public ImageEntity getImagem(Long id) {
		ImageEntity imageClient = repository.findByClientId(id);
		return imageClient;
	}
	
}
