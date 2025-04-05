package br.edu.senaisp.colegio.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(RecursoNotFound.class)
    public ResponseEntity<?> recursoNotFound(RecursoNotFound e, WebRequest request) {
        String idioma = request.getHeader("Accept-Language");
        idioma = (idioma == null) ? LocaleContextHolder.getLocale().getLanguage() : idioma;
        String msgLang = messageSource.getMessage("recursoNotFound", null, new Locale(idioma));
        MensagemErro mensagemErro = new MensagemErro(LocalDateTime.now(), msgLang, request.getDescription(false));
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
