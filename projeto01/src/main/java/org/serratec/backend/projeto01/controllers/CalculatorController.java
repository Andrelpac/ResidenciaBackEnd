package org.serratec.backend.projeto01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {
	
	@GetMapping("/soma")
	public String somar(@RequestParam Double n1, Double n2) {
		return "A soma dos numeros é : " + (n1+n2);
	}
	
	@GetMapping("/subtrair")
	public String subtrair(@RequestParam Double n1, Double n2) {
		return "A subtração dos numeros é : " + (n1-n2);
	}
	
	@GetMapping("/multiplicar")
	public String multiplicar(@RequestParam Double n1, Double n2) {
		return "A multiplicação dos numeros é : " + (n1*n2);
	}
	
	@GetMapping("/dividir")
	public String dividir(@RequestParam Double n1, Double n2) {
		if (n2 == 0) {
			return "Não é possivel dividir por 0";
		}
		return "A divisao dos numeros é : " + (n1/n2);
	}

}
