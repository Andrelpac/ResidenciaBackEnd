package org.com.serratec.backend.Projeto04.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class BookDTO {

	@NotNull
	@Size(min = 5, max = 30)
	private String titulo;

	@NotNull
	@Size(min = 3, max = 20)
	private String tipo;

	@NotNull
	@Size(min = 10, max = 40)
	private String autor;
	
	@Past
	private LocalDate data;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}


