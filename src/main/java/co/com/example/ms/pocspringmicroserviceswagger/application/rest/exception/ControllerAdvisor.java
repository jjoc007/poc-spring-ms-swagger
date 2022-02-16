package co.com.example.ms.pocspringmicroserviceswagger.application.rest.exception;

import co.com.example.ms.pocspringmicroserviceswagger.application.rest.model.response.ErrorResponse;
import co.com.example.ms.pocspringmicroserviceswagger.domain.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlePersonNotFoundException(
		PersonNotFoundException ex, WebRequest request) {

		return new ResponseEntity<>(ErrorResponse.builder()
			.code(HttpStatus.NOT_FOUND.value())
			.cause("Person not found")
			.build(), HttpStatus.NOT_FOUND);
	}

}
