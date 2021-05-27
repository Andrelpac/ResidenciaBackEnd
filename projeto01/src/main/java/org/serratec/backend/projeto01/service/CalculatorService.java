package org.serratec.backend.projeto01.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public Integer somar(Integer n1, Integer n2) {
		return (n1 + n2);
	}

	public Integer subtrair(Integer n1, Integer n2) {
		return (n1 - n2);
	}

	public Integer multiplicar(Integer n1, Integer n2) {
		return (n1 * n2);
	}

	public Double dividir(Double n1, Double n2) {
		if(n2 == 0) {
			System.out.println("Não podemos dividir por 0");
			return null;
		}
		return (n1 / n2);
	}
}
