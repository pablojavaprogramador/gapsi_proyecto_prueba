package com.gadsi.tienda.controller;

import io.swagger.annotations.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Api(
        value       = "ErroresController"
      , description = "Controlador de errores para Investigación - Cobranza."
)
@ControllerAdvice
public class ErroresController {

    private static final Logger LOG = LoggerFactory.getLogger(ErroresController.class);

    
    

}
