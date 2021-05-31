package org.serratec.backend.ProjetoCrud02.util;

import org.serratec.backend.ProjetoCrud02.exceptions.AccountNotFoundException;
import org.serratec.backend.ProjetoCrud02.exceptions.SaldoInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> tratarAccountNotFoundException(AccountNotFoundException exception) {
		return ResponseEntity.notFound()
				.header("x-error-msg", exception.getMessage())
				.build();
	}
	
	@ExceptionHandler(SaldoInsuficienteException.class)
	public ResponseEntity<String> tratarSaldoInsuficienteException(SaldoInsuficienteException exception) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.header("x-error-msg", exception.getMessage())
				.build();
	}
}
