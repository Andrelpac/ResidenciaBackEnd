package org.com.serratec.backend.Projeto04.mapper;

import org.com.serratec.backend.Projeto04.dto.BookDTO;
import org.com.serratec.backend.Projeto04.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public BookDTO toDTO(BookEntity entity) {
		BookDTO dto = new BookDTO();
		dto.setAutor(entity.getAutor());
		dto.setData(entity.getData());
		dto.setTipo(entity.getTipo());
		dto.setTitulo(entity.getTitulo());
		return dto;
	}
	
	public BookEntity toEntity(BookDTO dto) {
		BookEntity entity = new BookEntity();
		entity.setAutor(dto.getAutor());
		entity.setData(dto.getData());
		entity.setTipo(dto.getTipo());
		entity.setTitulo(dto.getTitulo());
		return entity;
	}
}
