package org.serratec.backend.projeto03.controllers;

import java.util.List;

import org.serratec.backend.projeto03.entity.TodoEntity;
import org.serratec.backend.projeto03.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private TodoService service;
	
	@GetMapping
	public List<TodoEntity> listAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public TodoEntity listById(@PathVariable Integer id) {
		return service.getById(id);
	}
	
	@PostMapping
	public TodoEntity create(@RequestBody TodoEntity todo) {
		return service.create(todo);
	}
	
	@PutMapping("/{id}")
	public TodoEntity update(@PathVariable Integer id, @RequestBody TodoEntity todo) {
		return service.update(id, todo);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return service.delete(id);
	}

}
