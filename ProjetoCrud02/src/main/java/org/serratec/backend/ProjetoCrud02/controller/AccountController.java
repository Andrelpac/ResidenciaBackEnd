package org.serratec.backend.ProjetoCrud02.controller;

import java.util.List;

import org.serratec.backend.ProjetoCrud02.entity.AccountEntity;
import org.serratec.backend.ProjetoCrud02.entity.OperationEntity;
import org.serratec.backend.ProjetoCrud02.exceptions.AccountNotFoundException;
import org.serratec.backend.ProjetoCrud02.exceptions.SaldoInsuficienteException;
import org.serratec.backend.ProjetoCrud02.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<AccountEntity>> findAll(){
		return new ResponseEntity<List<AccountEntity>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<AccountEntity> findByNumber(@PathVariable Integer numero) throws AccountNotFoundException {
		return new ResponseEntity<AccountEntity>(service.getByNumber(numero),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody AccountEntity conta) {
		service.create(conta);
		return new ResponseEntity<String>("Criado com sucesso", HttpStatus.CREATED);
	}
	
	@PutMapping("/{numero}")
	public ResponseEntity<AccountEntity> update(@PathVariable Integer numero, @RequestBody AccountEntity conta) throws AccountNotFoundException {
		return new ResponseEntity<AccountEntity>(service.update(numero, conta),HttpStatus.OK);
	}
	
	@PostMapping("/{numero}/operacao")
	public ResponseEntity<AccountEntity>operation(@PathVariable Integer numero, @RequestBody OperationEntity operacao) throws AccountNotFoundException, SaldoInsuficienteException {
		return new ResponseEntity<AccountEntity>(service.updateSaldo(numero, operacao),HttpStatus.OK);
	}
	
	@DeleteMapping("/{numero}")
	public ResponseEntity<String> delete(@PathVariable Integer numero) throws AccountNotFoundException {
		service.delete(numero);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
}
