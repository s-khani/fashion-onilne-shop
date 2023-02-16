package com.example.FashionOnlineShop.advisor;

import com.example.FashionOnlineShop.domain.ErrorResponse;
import com.example.FashionOnlineShop.exception.NotFoundException;
import com.example.FashionOnlineShop.exception.isAlreadyExistedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handlerNotFoundException(NotFoundException exc){
         return new ErrorResponse(
                 LocalDateTime.now(),
                 NOT_FOUND.value(),
                 exc.getMessage(),
                 ServletUriComponentsBuilder.fromCurrentRequest().build().toString()

         );
    }

    @ResponseStatus(CONFLICT)
    @ExceptionHandler(isAlreadyExistedException.class)
    public ErrorResponse handlerNotExistException(isAlreadyExistedException exc){
        return new ErrorResponse(
                LocalDateTime.now(),
                CONFLICT.value(),
                exc.getMessage(),
                ServletUriComponentsBuilder.fromCurrentRequest().build().toString()
        );



    }






}
