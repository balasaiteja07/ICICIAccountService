package com.icici.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.icici.account.dto.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(HDFCAcccountNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleHDFCAcccountNotFoundException(HDFCAcccountNotFoundException ex) {
		ExceptionDTO dto = getErrorDetails(ex);
		return new ResponseEntity<ExceptionDTO>(dto, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ICICIAccountNotFoundException.class)
	public ResponseEntity<?> handleICICIAccountNotFoundException(ICICIAccountNotFoundException ex){
		ExceptionDTO dto = getErrorDetails(ex);
		return new ResponseEntity<ExceptionDTO>(dto,HttpStatus.NOT_FOUND);
	}
	
	private ExceptionDTO getErrorDetails(RuntimeException ex) {
		ExceptionDTO dto = new ExceptionDTO();
		dto.setErrorDescription(ex.getMessage());
		dto.setErrorCode(HttpStatus.NOT_FOUND.value());
		return dto;
		
		
		
	}

}
