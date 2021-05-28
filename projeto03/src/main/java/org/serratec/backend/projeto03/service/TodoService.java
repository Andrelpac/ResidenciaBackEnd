package org.serratec.backend.projeto03.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.serratec.backend.projeto03.entity.TodoEntity;
import org.serratec.backend.projeto03.exceptions.TodoNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	List<TodoEntity> list = new ArrayList<TodoEntity>();

	public TodoEntity create(TodoEntity todo) {
		list.add(todo);
		return todo;
	}

	public List<TodoEntity> getAll() {
		return list;
	}

	public TodoEntity getById(Integer id) throws TodoNotFoundException {
		for (TodoEntity todoEntity : list) {
			if (todoEntity.getId() == id) {
				return todoEntity;
			}
		}
		throw new TodoNotFoundException("Não foi possivel encontrar esse id: " + id);
	}
	
	public TodoEntity update(Integer id, TodoEntity todo) throws TodoNotFoundException {
//		for (int contador = 0; contador < list.size() ; contador++) {
//			TodoEntity todoEntity = list.get(contador);
//			if (todoEntity.getId() == id) {
//				if(todo.getName() != null) {
//					todoEntity.setName(todo.getName()); //Passando o que o usuario mandou no Objeto Todo para o meu Objeto da lista, todoEntity.
//				}
//				if(todo.getDescription() != null) {
//					todoEntity.setDescription(todo.getDescription());
//				}
//				return todoEntity;
//			}
//			
//		}
		for (TodoEntity todoEntity : list) {
			if (todoEntity.getId() == id) {
				if(todo.getName() != null) {
					todoEntity.setName(todo.getName()); //Passando o que o usuario mandou no Objeto Todo para o meu Objeto da lista, todoEntity.
				}
				if(todo.getDescription() != null) {
					todoEntity.setDescription(todo.getDescription());
				}
				return todoEntity;
			}
		}
		throw new TodoNotFoundException("Não foi possivel encontrar esse id: " + id);
	}
	
	public String delete(Integer id) throws Exception {
		for (TodoEntity todoEntity : list) {
			if (todoEntity.getId() == id) {
				list.remove(todoEntity);
				return "Deletado com sucesso";
			}
		}
		throw new Exception(" Não foi possivel deletar");
	}
}
