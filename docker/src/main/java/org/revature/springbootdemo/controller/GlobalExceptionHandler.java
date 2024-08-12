//package org.revature.springbootdemo.controller;
//
//
//import org.revature.springbootdemo.exceptions.ProjectNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(ProjectNotFoundException.class)
//    public ResponseEntity<String> handleProjectNotFoundException(ProjectNotFoundException exception){
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//}
