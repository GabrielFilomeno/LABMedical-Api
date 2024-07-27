package com.example.LABMedical_API.exceptions;

import com.example.LABMedical_API.exceptions.dtos.ErroResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Objects;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> trataCampoInvalido(MethodArgumentNotValidException exception) {

        ErroResponse response = new ErroResponse(Objects.requireNonNull(exception.getFieldError()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> trataDataOuEnumInvalido(HttpMessageNotReadableException exception) {

        ErroResponse response = new ErroResponse();

        response.setCampo("Data");
        response.setMensagem("A data deve estar no formato dd/MM/aaaa");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroResponse> teste(DataIntegrityViolationException exception) {

        ErroResponse response = new ErroResponse();

        response.setCampo("Falha ao cadastrar pois há algum dado duplicado");
        response.setMensagem(String.valueOf(exception.getMostSpecificCause()));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
