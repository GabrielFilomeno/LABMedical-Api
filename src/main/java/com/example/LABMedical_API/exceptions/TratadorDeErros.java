package com.example.LABMedical_API.exceptions;

import com.example.LABMedical_API.exceptions.dtos.ErroResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.Objects;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> trataCampoInvalido(MethodArgumentNotValidException exception) {

        ErroResponse response = new ErroResponse(Objects.requireNonNull(exception.getFieldError()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ErroResponse> trataDataInvalida(DateTimeParseException exception) {

        ErroResponse response = new ErroResponse();

        response.setCampo("Data");
        response.setMensagem("Formato de data inválido. Use o formato dd/MM/yyyy ou horário no formato HH:mm");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroResponse> trataDadosDuplicados(DataIntegrityViolationException exception) {

        ErroResponse response = new ErroResponse();

        response.setCampo("Erro");
        response.setMensagem(String.valueOf(exception.getMostSpecificCause()));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResponse> trataEntityNotFound(EntityNotFoundException exception) {

        ErroResponse response = new ErroResponse();

        response.setCampo("Erro");
        response.setMensagem(exception.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
