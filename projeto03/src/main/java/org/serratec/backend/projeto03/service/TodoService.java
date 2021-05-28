package org.serratec.backend.projeto03.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.serratec.backend.projeto03.entity.TodoEntity;
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

	public TodoEntity getById(Integer id) {
		for (TodoEntity todoEntity : list) {
			if (todoEntity.getId() == id) {
				return todoEntity;
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}

	public TodoEntity update(Integer id, TodoEntity todo) {
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
		System.out.println("Não temos tarefas com esse id");
		return null;
	}
	
	public String delete(Integer id) {
		for (TodoEntity todoEntity : list) {
			if (todoEntity.getId() == id) {
				list.remove(todoEntity);
				return "Deletado com sucesso";
			}
		}
		return "Id não encontrado";
	}
}
