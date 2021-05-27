package org.serratec.backend.projeto01.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projeto01.entity.CalculatorEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	List<CalculatorEntity> Lista = new ArrayList<CalculatorEntity>();
	
	public Integer somar(CalculatorEntity calculator) {
		if (calculator.getOperador() != null) {
			switch (calculator.getOperador()) {
			case "+":
				return (calculator.getNumber1() + calculator.getNumber2());
			case "-":
				return (calculator.getNumber1() - calculator.getNumber2());
			case "*":
				return (calculator.getNumber1() * calculator.getNumber2());
			case "/":
				if (calculator.getNumber2() == 0) {
					System.out.println("Não podemos dividir por 0");
					return null;
				}
				return (calculator.getNumber1() / calculator.getNumber2());
			default:
				System.out.println("Operador invalido para esse endpoint!");
				return null;
			}
		}
		System.out.println("Operador invalido para esse endpoint!");
		return null;
	}
	
	public void create(CalculatorEntity calculator) {
		Lista.add(calculator);
	}
	
	public List<CalculatorEntity> getAll(){
		return this.Lista;
	}
	
	public CalculatorEntity procurar(Integer n1) {
		for (CalculatorEntity calculatorEntity : Lista) {
			if(calculatorEntity.getNumber1() == n1) {
				return calculatorEntity;
			}
		}
		System.out.println("Numero não encontrado");
		return null;
	}
}
