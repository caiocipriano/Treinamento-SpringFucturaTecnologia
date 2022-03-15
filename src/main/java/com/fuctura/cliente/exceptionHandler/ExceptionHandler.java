package com.fuctura.cliente.exceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice						
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Campo> campos = new ArrayList<Campo>();
		for(ObjectError error:ex.getBindingResult().getAllErrors()){
			String nome = ((FieldError)error).getField();
			String messagem = error.getDefaultMessage();
			campos.add(new Campo(nome, messagem));
		}
		
		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setDataHora(LocalDateTime.now());
		erro.setTitulo("Um ou mais campos estao invalidos");
		erro.setCampos(campos);
		
		return handleExceptionInternal(ex, "Campos Invalidos na Requisicao", headers, status, request);
	}
}
