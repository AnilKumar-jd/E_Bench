package com.ebench.userservice.exceptionHandler;

import jdk.net.SocketFlow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> resourceNotFound(ResourceNotFoundException ex) {
        Map<String,Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        errorInfo.put("status",response);
        errorInfo.put("data",null);
        return new ResponseEntity<Map<String,Object>>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<Map<String,Object>> resourceAlreadyExists(ResourceAlreadyExists ex) {
        Map<String,Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.CONFLICT.value()));
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        errorInfo.put("status",response);
        errorInfo.put("data",null);
        return new ResponseEntity<Map<String,Object>>(errorInfo, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadReqException.class)
    public ResponseEntity<Map<String,Object>> badReqException(BadReqException ex) {
        Map<String,Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        errorInfo.put("status",response);
        errorInfo.put("data",null);
        return new ResponseEntity<Map<String,Object>>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Map<String,Object>> unauthorizedException(UnauthorizedException ex) {
        Map<String,Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        errorInfo.put("status",response);
        errorInfo.put("data",null);
        return new ResponseEntity<Map<String,Object>>(errorInfo, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<Map<String,Object>> defaultError(DefaultException ex) {
        Map<String,Object> errorInfo = new HashMap<>();
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        errorInfo.put("status",response);
        errorInfo.put("data",null);
        return new ResponseEntity<Map<String,Object>>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  // this  will return this type response {}.....
   /* @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setHttpCode(HttpStatus.NOT_FOUND.toString());
        response.setMessage(ex.getMessage());
        response.setSuccess(false);

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }*/
}
