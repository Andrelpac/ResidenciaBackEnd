package org.serratec.backend.projeto01.entity;

public class CalculatorEntity {

	private Integer number1;
	
	private Integer number2;
	
	private String operador;

	private CalculatorEntity(Integer number1, Integer number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
	
	
}
