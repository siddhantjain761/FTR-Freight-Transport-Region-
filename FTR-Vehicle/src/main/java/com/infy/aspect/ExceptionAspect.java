package com.infy.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.exception.VEHICLE_NOT_FOUND_EXCEPTION;
import com.infy.exception.VEHICLE_UPDATE_ALREADY_EXISTS;
import com.infy.util.ErrorMessage;

import java.util.stream.Collectors;

import javax.validation.ValidationException;


@RestControllerAdvice
public class ExceptionAspect {
	
	@ExceptionHandler(VEHICLE_NOT_FOUND_EXCEPTION.class)
	public ResponseEntity<ErrorMessage> vehicleNotFoundExceptionHandler(VEHICLE_NOT_FOUND_EXCEPTION e){
		ErrorMessage msg = new ErrorMessage();
		msg.setMessage(e.getMessage());
		msg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		msg.setUrl("/ftr/vehicles");
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		return entity;
	}
	@ExceptionHandler(VEHICLE_UPDATE_ALREADY_EXISTS.class)
	public ResponseEntity<ErrorMessage> vehicleUpdateAlreadyExistsExceptionHandler(VEHICLE_UPDATE_ALREADY_EXISTS e){
		ErrorMessage msg = new ErrorMessage();
		msg.setMessage(e.getMessage());
		msg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		msg.setUrl("/ftr/vehicles");
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		return entity;
	}
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorMessage> validationExceptionHandler(ValidationException e){
		ErrorMessage msg = new ErrorMessage();
		e.printStackTrace();
		msg.setMessage("invalid.data");
		msg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		msg.setUrl("/ftr/vehicles");
		System.out.println(msg);
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> ExceptionHandler(Exception e){
		ErrorMessage msg = new ErrorMessage();
//		msg.setMessage("Oops! somehting went wrong, please try again!");
		msg.setMessage(e.getMessage());
		msg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		msg.setUrl("/ftr/vehicles");
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		return entity;
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

}
