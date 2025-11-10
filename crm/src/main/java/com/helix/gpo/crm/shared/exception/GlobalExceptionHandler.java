package com.helix.gpo.crm.shared.exception;

import com.helix.gpo.crm.shared.exception.types.AuthTokenInvalidException;
import com.helix.gpo.crm.shared.exception.types.FileUploadException;
import com.helix.gpo.crm.shared.exception.types.ResourceAlreadyExistsException;
import com.helix.gpo.crm.shared.exception.types.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(AuthTokenInvalidException.class)
    public ResponseEntity<ErrorResponse> handleAuthTokenInvalidException(WebRequest webRequest, Locale locale) {
        String message = messageSource.getMessage("error.auth-token.invalid", null, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "UNAUTHORIZED",
                HttpStatus.UNAUTHORIZED.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ErrorResponse> handleFileUploadException(WebRequest webRequest, Locale locale) {
        String message = messageSource.getMessage("error.upload.failed", null, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "BAD_REQUEST",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(WebRequest webRequest, Locale locale,
                                                                              ResourceAlreadyExistsException exception) {
        Object[] args = { exception.getResourceName() };
        String message = messageSource.getMessage("error.resource.exists", args, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "CONFLICT",
                HttpStatus.CONFLICT.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(WebRequest webRequest, Locale locale,
                                                                         ResourceNotFoundException exception) {
        Object[] args = { exception.getResourceName() };
        String message = messageSource.getMessage("error.resource.not.found", args, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "NOT_FOUND",
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(WebRequest webRequest, Locale locale) {
        String message = messageSource.getMessage("error.internal.server", null, locale);
        ErrorResponse errorDetails = new ErrorResponse(
                LocalDateTime.now(),
                message,
                webRequest.getDescription(true),
                "INTERNAL_SERVER_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

        errorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
