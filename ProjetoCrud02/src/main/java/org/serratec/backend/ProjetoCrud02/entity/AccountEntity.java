package org.serratec.backend.ProjetoCrud02.entity;

public class AccountEntity {
	
	private Long id;

	private Integer numero;

	private String nome;

	private Double saldo;

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
