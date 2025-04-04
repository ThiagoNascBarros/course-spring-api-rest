package br.edu.senaisp.colegio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNotFound.class)
    public ResponseEntity<?> recursoNotFound(RecursoNotFound e, WebRequest request) {
        MensagemErro mensagemErro = new MensagemErro(LocalDateTime.now(), e.getMessage(), request.getDescription(false));
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
