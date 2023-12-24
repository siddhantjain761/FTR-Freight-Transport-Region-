package com.demo.Handler;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.demo.Error.ErrorMessage;
import com.demo.Exception.ItemIdNotAvaliableException;
import com.demo.Exception.ItemNotAvaliableException;
 

@RestControllerAdvice
@EnableWebMvc
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(ItemNotAvaliableException.class)
	public ResponseEntity<ErrorMessage>  ItemValidation(ItemNotAvaliableException e){
		
		ErrorMessage e1 = new ErrorMessage();

		
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		//e.printStackTrace();
		e1.setMessage(e.getMessage());
		System.out.println("No such Item type exists.");
		return new ResponseEntity<>(e1,HttpStatus.OK);
		
	}
	@ExceptionHandler(ItemIdNotAvaliableException.class)
	public ResponseEntity<ErrorMessage>  ItemValidation(ItemIdNotAvaliableException e){
		
		ErrorMessage e1 = new ErrorMessage();

		
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		e.printStackTrace();
		e1.setMessage(e.getMessage());
		System.out.println("Terminal details not found for ID");
		return new ResponseEntity<>(e1,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object>  ItemValidation(Exception e){
		
		ErrorMessage e1 = new ErrorMessage();

		
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		e1.setMessage(e.getMessage());
		
		e.printStackTrace();
		System.out.println("VALUE2");
		
		return ResponseEntity.badRequest().body(e1);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handelValidationexception(MethodArgumentNotValidException e){
		
		ErrorMessage e1 = new ErrorMessage();
        //e.printStackTrace();
        e1.setMessage(e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
//		String bindMsg = "";
//		for(ObjectError err:e.getAllErrors()) {
//			  bindMsg += err.getDefaultMessage()+",";
//		}
//		e1.setMessage(bindMsg);
		e1.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		 
		System.out.println("METHOD ARGUMENT EXCEPTION");
		return  new ResponseEntity<>(e1,HttpStatus.BAD_REQUEST);
		
	}
	//Validation failures on URI parameters	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleConstraintValidationExceptions(
			ConstraintViolationException ex) {
		
			 ErrorMessage error = new ErrorMessage();
	         error.setStatusCode(HttpStatus.BAD_REQUEST.value());
	         error.setMessage(ex.getConstraintViolations().stream()
	                                                         .map(ConstraintViolation::getMessage)
	        		                                      .collect(Collectors.joining(", ")));
	         return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		    
	}
}