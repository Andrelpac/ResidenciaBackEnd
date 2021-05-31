package org.serratec.backend.projeto03.controllers;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto03.entity.TodoEntity;
import org.serratec.backend.projeto03.exceptions.TodoNotFoundException;
import org.serratec.backend.projeto03.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

	List<TodoEntity> list = new ArrayList<TodoEntity>();

	@Autowired
	private TodoService service;

	@GetMapping
	public ResponseEntity<List<TodoEntity>> listAll() {
		return ResponseEntity.ok().header("Custom-Header", "Testando").header("Teste 2", "Teste 3")
				.body(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TodoEntity> listById(@PathVariable Integer id) throws TodoNotFoundException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Custom header", "Testando");
		TodoEntity body = service.getById(id);
		return new ResponseEntity<TodoEntity>(body, headers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TodoEntity> create(@RequestBody TodoEntity todo) {
		return new ResponseEntity<TodoEntity>(service.create(todo), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public TodoEntity update(@PathVariable Integer id, @RequestBody TodoEntity todo) throws TodoNotFoundException {
		return service.update(id, todo);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) throws Exception {
		return service.delete(id);
	}
	
}
