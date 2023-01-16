package com.ntg.socialnetworkspringcloudin28minuts.controller.controllerAdvice;

import com.ntg.socialnetworkspringcloudin28minuts.exception.ExceptionDetails;
import com.ntg.socialnetworkspringcloudin28minuts.exception.UserNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> onUserNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationExceptionResponse onConstraintValidationException(
            ConstraintViolationException e
    ) {
        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new Violation(
                                LocalDateTime.now(),
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .collect(Collectors.toList());
        return new ValidationExceptionResponse(violations);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationExceptionResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(LocalDateTime.now(), error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ValidationExceptionResponse(violations);
    }
}
