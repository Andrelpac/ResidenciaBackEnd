package org.serratec.backend.projeto01.controllers;

import org.serratec.backend.projeto01.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculatorController {
	
	@Autowired
	CalculatorService service;
	
	@GetMapping("/soma")
	public Integer somar(@RequestParam Integer n1, Integer n2) {
		return service.somar(n1, n2);
	}
	
	@GetMapping("/subtrair")
	public Integer subtrair(@RequestParam Integer n1, Integer n2) {
		return service.subtrair(n1, n2);
	}
	
	@GetMapping("/multiplicar")
	public Integer multiplicar(@RequestParam Integer n1, Integer n2) {
		return service.multiplicar(n1, n2);
	}
	
	@GetMapping("/dividir")
	public Double dividir(@RequestParam Double n1, Double n2) {
		return service.dividir(n1, n2);
	}

}
