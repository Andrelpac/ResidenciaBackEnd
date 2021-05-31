package org.serratec.backend.ProjetoCrud02.controller;

import java.util.List;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.serratec.backend.ProjetoCrud02.entity.OperationEntity;
import org.serratec.backend.ProjetoCrud02.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@GetMapping
	public List<AccountEntity> findAll(){
		return service.getAll();
	}
	
	@GetMapping("/{numero}")
	public AccountEntity findByNumber(@PathVariable Integer numero) {
		return service.getByNumber(numero);
	}

	@PostMapping
	public void create(@RequestBody AccountEntity conta) {
		service.create(conta);
	}
	
	@PutMapping("/{numero}")
	public AccountEntity update(@PathVariable Integer numero, @RequestBody AccountEntity conta) {
		return service.update(numero, conta);
	}
	
	@PostMapping("/{numero}/operacao")
	public AccountEntity operation(@PathVariable Integer numero, @RequestBody OperationEntity operacao) {
		return service.updateSaldo(numero, operacao);
	}
	
	@DeleteMapping("/{numero}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
