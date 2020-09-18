package com.sriraminc.mobileappws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sriraminc.mobileppws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String errMessageDesc = ex.getLocalizedMessage();
		if(errMessageDesc == null) errMessageDesc = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errMessageDesc);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = {UserServiceException.class, NullPointerException.class})
	public ResponseEntity<Object> handleUserServiceException(Exception ex, WebRequest request){
		
		String errMessageDesc = ex.getLocalizedMessage();
		if(errMessageDesc == null) errMessageDesc = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errMessageDesc);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
