package com.example.demo.handler;

import com.example.demo.exception.NotEnoughProductException;
import com.example.demo.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {
    @ResponseBody
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handler1(EmptyResultDataAccessException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handler2(NotFoundException e) {
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NotEnoughProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handler3(NotEnoughProductException e) {
        return e.getMessage();
    }
}
