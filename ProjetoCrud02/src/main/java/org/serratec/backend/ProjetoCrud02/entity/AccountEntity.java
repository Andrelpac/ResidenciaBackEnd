package org.serratec.backend.ProjetoCrud02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Conta")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 6)
	private Integer numero;

	@Column(nullable = false)
	private String nome;

	private Double saldo;

	public AccountEntity() {

	}

	public AccountEntity(Integer numero, String nome, Double saldo) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
