package org.com.serratec.backend.Projeto04.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
@Table(name = "LIVRO")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
//	@Temporal(TemporalType.DATE)
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private CategoriaEntity categoria;
	
	@ManyToMany(mappedBy = "books")
	private List<AutorEntity> autores;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
