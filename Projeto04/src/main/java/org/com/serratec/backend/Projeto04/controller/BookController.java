package org.com.serratec.backend.Projeto04.controller;

import java.util.List;

import javax.validation.Valid;

import org.com.serratec.backend.Projeto04.dto.BookDTO;
import org.com.serratec.backend.Projeto04.entity.CategoriaEntity;
import org.com.serratec.backend.Projeto04.exceptions.BookNotFoundException;
import org.com.serratec.backend.Projeto04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class BookController {

	@Autowired
	BookService service;

	@GetMapping
	public ResponseEntity<List<BookDTO>> getAll(
			@RequestParam(name = "ordenar", required = false, defaultValue = "id") String ordem ) {
		return new ResponseEntity<List<BookDTO>>(service.findAll(ordem), HttpStatus.OK);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<CategoriaEntity>> get(
			@RequestParam(name = "ordenar", required = false, defaultValue = "id") String ordem ) {
		return new ResponseEntity<List<CategoriaEntity>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getById(@PathVariable Long id) throws BookNotFoundException {
		return new ResponseEntity<BookDTO>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BookDTO> create(@Valid @RequestBody BookDTO dto) {
		return new ResponseEntity<BookDTO>(service.create(dto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> update(@PathVariable Long id, @RequestBody BookDTO dto)
			throws BookNotFoundException {
		return new ResponseEntity<BookDTO>(service.update(id, dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
}
