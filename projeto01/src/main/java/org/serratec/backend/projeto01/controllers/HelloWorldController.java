package org.serratec.backend.projeto01.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saudacao")
public class HelloWorldController {

	@RequestMapping("/ola")
	public String olaMundo(@RequestParam String nome) {
		return nome;
	}
	
	@RequestMapping("/numero")
	public Integer olaNumero() {
		return 50;
	}
	
}
