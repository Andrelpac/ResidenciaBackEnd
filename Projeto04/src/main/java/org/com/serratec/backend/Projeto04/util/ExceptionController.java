package org.com.serratec.backend.Projeto04.util;

import org.com.serratec.backend.Projeto04.exceptions.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> tratarBookNotFoundExcpetion(BookNotFoundException exception){
		return ResponseEntity.notFound()
				.header("x-error-msg", exception.getMessage())
				.build();
	}

}
