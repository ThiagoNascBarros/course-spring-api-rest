package br.edu.senaisp.colegio.exceptions;

import java.time.LocalDateTime;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private LocaleResolver localeResolver;

    @ExceptionHandler(RecursoNotFound.class)
    public ResponseEntity<?> recursoNotFound(RecursoNotFound e, HttpServletRequest request) {
    	log.error(e.getMessage());
        Locale local = localeResolver.resolveLocale(request);
        System.err.println(local.getLanguage());
        String msgLang = messageSource.getMessage("recursoNotFound", null, local);
        MensagemErro mensagemErro = new MensagemErro(LocalDateTime.now(), msgLang, request.getContextPath());
        return new ResponseEntity<>(mensagemErro, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> geralRunTimeException(RecursoNotFound e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> geralNoResourceFoundException(RecursoNotFound e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
