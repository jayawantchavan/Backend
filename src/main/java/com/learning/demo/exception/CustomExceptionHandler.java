package com.learning.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // enabling auto scanning & configuration
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomExceptionHandler() {
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {

		return new ResponseEntity<Object>("Record Not Foundss", HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ex.printStackTrace();
		return new ResponseEntity<Object>("Validation Failed", HttpStatus.BAD_REQUEST);
	}
}
