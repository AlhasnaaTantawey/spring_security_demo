package com.global.error;

import com.global.dto.ErrorResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//	                                                              HttpHeaders headers,
//	                                                              HttpStatusCode status,
//	                                                              WebRequest request) {
//	    List<String> errors = new ArrayList<>();
//
//	    // Log and collect detailed validation errors for each field
//	    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
//	        String errorMessage = "Field: " + fieldError.getField() + " - Rejected value: [" +
//	                              fieldError.getRejectedValue() + "] - Error: " + fieldError.getDefaultMessage();
//			//log.debug("Field Error: " + errorMessage);
//	        errors.add(errorMessage);
//	    }
//
//	    for (ObjectError objectError : ex.getBindingResult().getGlobalErrors()) {
//	        String errorMessage = "Object: " + objectError.getObjectName() + " - Error: " + objectError.getDefaultMessage();
//			//log.debug("Global Error: " + errorMessage);
//	        errors.add(errorMessage);
//	    }
//
//	    ErrorResponseDto errorResponseDto = new ErrorResponseDto("Validation failed", errors);
//	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDto);
//	}



	@ExceptionHandler(EntityNotFoundException.class)
	  public ResponseEntity<?> handleRecordNotFound(EntityNotFoundException ex){
		  
		ErrorResponseDto error = new ErrorResponseDto(ex.getLocalizedMessage(), ex.getMessage());
		  return ResponseEntity.
				  status(HttpStatus.NOT_FOUND).
				  body(error);
	  }
	
	
	
//	@ExceptionHandler(DuplicateRecordException.class)
//	  public ResponseEntity<?> handleDuplicateRecord(DuplicateRecordException ex){
//
//		ErrorResponseDto error = new ErrorResponseDto(ex.getLocalizedMessage(), Collections.singletonList(ex.getMessage()));
//		  return ResponseEntity.
//				  status(HttpStatus.BAD_REQUEST).
//				  body(error);
//	  }
	
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<?> handleAllException (Exception ex ,  WebRequest request){
		  
		ex.printStackTrace();
		//log.error(ex.getMessage());
		ErrorResponseDto error = new ErrorResponseDto(ex.getLocalizedMessage(), ex.getMessage());
		  return ResponseEntity.
				  status(HttpStatus.EXPECTATION_FAILED).
				  body(error);
	  }

	// Handle unauthorized access (e.g., AccessDeniedException)
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponseDto> handleAccessDeniedException(AccessDeniedException ex) {
		ErrorResponseDto errorResponse = new ErrorResponseDto(
//				LocalDateTime.now(),
				"Access Denied: You are not authorized to perform this action.",
				ex.getMessage()
		);
		return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
	}

	// Handle authentication failures (e.g., BadCredentialsException)
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorResponseDto> handleBadCredentialsException(BadCredentialsException ex) {
		ErrorResponseDto errorResponse = new ErrorResponseDto(
//				LocalDateTime.now(),
				"Invalid Username or Password.",
				ex.getMessage()
		);
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

	// Handle username not found
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleUsernameNotFoundException(UsernameNotFoundException ex) {
		ErrorResponseDto errorResponse = new ErrorResponseDto(
//				LocalDateTime.now(),
				"User not found.",
				ex.getMessage()
		);
	//	ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("username not found");
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Catch-all for other exceptions
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex) {
//		ErrorResponseDto errorResponse = new ErrorResponseDto(
//				LocalDateTime.now(),
//				"An unexpected error occurred.",
//				ex.getMessage()
//		);
//		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//	}


}
