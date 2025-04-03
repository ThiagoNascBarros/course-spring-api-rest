package br.edu.senaisp.colegio.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {



    public ResponseEntity<?> recursoNotFound(RecursoNotFound e, WebRequest request) {

        return null;
    }

}
