package com.example.demo;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class DefaultExceptionhandler {
	@ExceptionHandler(value=ResourceNotFoundException.class)
public ResponseEntity<ErrorDetail>handleResourceNotFound
(ResourceNotFoundException exception,WebRequest request){
		String errormessagedesc=exception.getLocalizedMessage();
		if(errormessagedesc==null)errormessagedesc=exception.toString();
		ErrorDetail errordetails=new ErrorDetail(new Date(),errormessagedesc,request.getDescription(false));
		
		return new  ResponseEntity<>(errordetails,new HttpHeaders(),HttpStatus.NOT_FOUND);}
	/*	@ExceptionHandler(APIException.class)
		public ResponseEntity<ErrorDetail>APIException
		(APIException exception,WebRequest request){
			String errormessagedesc=exception.getLocalizedMessage();
			if(errormessagedesc==null)errormessagedesc=exception.toString();
			ErrorDetail errordetails=new ErrorDetail(new Date(),errormessagedesc,request.getDescription(false));
			
			return new  ResponseEntity<>(errordetails,new HttpHeaders(),HttpStatus.NOT_FOUND);}*/
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail>handleglobalException
	(Exception exception,WebRequest request){
		String errormessagedesc=exception.getLocalizedMessage();
		if(errormessagedesc==null)errormessagedesc=exception.toString();
		ErrorDetail errordetails=new ErrorDetail(new Date(),errormessagedesc,request.getDescription(false));
		
		return new  ResponseEntity<>(errordetails,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
