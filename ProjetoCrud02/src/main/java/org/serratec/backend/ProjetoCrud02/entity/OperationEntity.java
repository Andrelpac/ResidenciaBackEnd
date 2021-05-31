package org.serratec.backend.ProjetoCrud02.entity;

import org.serratec.backend.ProjetoCrud02.enums.TypeOperation;

public class OperationEntity {

	private TypeOperation operacao;

	private Double valor;

	public OperationEntity(TypeOperation operacao, Double valor) {
		super();
		this.operacao = operacao;
		this.valor = valor;
	}

	public TypeOperation getOperacao() {
		return operacao;
	}

	public void setOperacao(TypeOperation operacao) {
		this.operacao = operacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
