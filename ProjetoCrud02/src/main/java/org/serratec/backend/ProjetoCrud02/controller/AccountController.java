package org.serratec.backend.ProjetoCrud02.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.ProjetoCrud02.dto.AccountDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class AccountController {
	
	@Autowired
	AccountService service;
	
	@GetMapping
	public ResponseEntity<List<AccountEntity>> findAll(@RequestParam(required = false, defaultValue = "id")){
		return new ResponseEntity<List<AccountEntity>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<AccountEntity>> findByNumber(@PathVariable String nome) throws AccountNotFoundException {
		return new ResponseEntity<List<AccountEntity>>(service.getByName(nome),HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> create(@RequestBody AccountEntity conta) {
		service.create(conta);
		return new ResponseEntity<String>("Criado com sucesso", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AccountDTO> update(@PathVariable  Long id, @RequestBody AccountEntity conta) throws AccountNotFoundException {
		return new ResponseEntity<AccountDTO>(service.update(id, conta),HttpStatus.OK);
	}
	
	@PostMapping("/{id}/operacao")
	public ResponseEntity<AccountDTO>operation(@PathVariable  Long id, @RequestBody OperationEntity operacao) throws AccountNotFoundException, SaldoInsuficienteException {
		return new ResponseEntity<AccountDTO>(service.updateSaldo(id, operacao),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable  Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
}
