package org.com.serratec.backend.controller;

import java.util.List;

import org.com.serratec.backend.entity.TodoEntity;
import org.com.serratec.backend.service.TodoService;
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
	TodoService service;
	
	@GetMapping
	public List<TodoEntity> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public TodoEntity findById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping
	public TodoEntity create(@RequestBody TodoEntity todo) {
		return service.create(todo);
	}
	
	@PutMapping("/{id}")
	public TodoEntity update(@PathVariable Long id, @RequestBody TodoEntity todo) {
		return service.update(id, todo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
