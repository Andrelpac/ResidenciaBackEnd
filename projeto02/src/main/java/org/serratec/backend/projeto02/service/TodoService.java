package org.serratec.backend.projeto02.service;

import java.util.Arrays;
import java.util.List;

import org.serratec.backend.projeto02.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	public List<TodoEntity> create() {
		return Arrays.asList(new TodoEntity(1, "Ir ao Mercado", "Ir ao mercado para comprar minha janta"),
				new TodoEntity(2, "Reunião as 16 horas", "Reunião com fulano de tal as 16 horas"));
	}
}
