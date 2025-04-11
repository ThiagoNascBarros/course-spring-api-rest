package br.edu.senaisp.colegio.exception;

import java.time.LocalDateTime;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import br.edu.senaisp.colegio.ColegioApplication;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	Logger log = LoggerFactory.getLogger(
				GlobalExceptionHandler.class);	
	
	@Autowired
	MessageSource messageSource;
	@Autowired
	LocaleResolver localeResolver;
	@ExceptionHandler(RecursoNotFound.class)
	public ResponseEntity<?> 
	recursoNotFound(RecursoNotFound e, HttpServletRequest request) {
		log.error(e.getMessage());
		Locale local = localeResolver.resolveLocale(request);
		
	String msgLang = messageSource.getMessage("recurso_notfound"
									, null, local);
		MensagemErro msg = 
				new MensagemErro(
						LocalDateTime.now()
					   ,msgLang   
					   ,request.getContextPath()
					   );

	return new ResponseEntity<>
		(msg, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<?> 
			geralNoResourceFoundException(NoResourceFoundException e, 
						WebRequest request) {
		System.err.println("AQUI 3");
	return new ResponseEntity<>
		(e.getMessage(), HttpStatus.NOT_FOUND);

	}	
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> 
			geralRuntimeException(RuntimeException e, 
						WebRequest request) {
		System.err.println("AQUI 2");
	return new ResponseEntity<>
		(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}	

}
