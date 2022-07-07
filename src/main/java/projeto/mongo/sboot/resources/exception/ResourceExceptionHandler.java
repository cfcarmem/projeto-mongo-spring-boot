package projeto.mongo.sboot.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import projeto.mongo.sboot.services.exceptions.ObjectNotFoundException;


//vai interceptar as exceptions
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> recursoNaoExiste(ObjectNotFoundException erro, HttpServletRequest request){
		String error = "Objeto não existe.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, erro.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
