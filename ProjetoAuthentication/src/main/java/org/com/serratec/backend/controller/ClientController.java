package org.com.serratec.backend.controller;

import java.io.IOException;
import java.util.List;

import org.com.serratec.backend.entity.ClientDTO;
import org.com.serratec.backend.entity.ClientEntity;
import org.com.serratec.backend.entity.Imagem;
import org.com.serratec.backend.service.ClientService;
import org.com.serratec.backend.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ClientController {
	
	@Autowired
	ClientService service;
	
	@Autowired
	ImageService imageService;
	
	@GetMapping("/client")
	public List<ClientEntity> findAll(){
		return service.getAll();
	}
	
	@GetMapping(path = "client/{clientId}/image/")
	public ResponseEntity<byte[]> getImage(@PathVariable Long clientId) {
		Imagem image = imageService.getImage(clientId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", image.getMimetype());
		headers.add("content-length", String.valueOf(image.getData().length));
		return new ResponseEntity<>(image.getData(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/client/{id}")
	public ClientEntity findById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping(path = "create")
	public ClientDTO create(@RequestParam MultipartFile file, @RequestPart ClientEntity entity ) throws IOException {
		return service.create(entity,file);
	}

}
