package com.MobileApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(NameException.class)
	public ResponseEntity<Object> nameExceptionHandling(NameException ne){
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> idExceptionHandling(IdNotFoundException ie){
		return new ResponseEntity<>(ie.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userExceptionHandling(UserNotFoundException ue){
		return new ResponseEntity<>(ue.getMessage(),HttpStatus.NOT_FOUND);
	}
	
   @ExceptionHandler(CharNotFoundException.class)
   public ResponseEntity<Object> charExceptionHandling(CharNotFoundException ce){
	   return  new ResponseEntity<>(ce.getMessage(),HttpStatus.NOT_FOUND);
   }

}
