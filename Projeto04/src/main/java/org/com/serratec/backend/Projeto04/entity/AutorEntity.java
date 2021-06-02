package org.com.serratec.backend.Projeto04.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany
	@JoinTable
	(joinColumns = @JoinColumn(referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "id"))
	private List<BookEntity> books;
}
