package com.deckofcards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import java.time.OffsetDateTime;

@ControllerAdvice
@RestController
public class CustomExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                httpStatus.value(),
                httpStatus.toString(),
                e.getMessage(),
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {RessourceNotFoundException.class})
    public final ResponseEntity<ExceptionResponse> handleRessourceNotFoundException(Exception e) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                httpStatus.value(),
                httpStatus.toString(),
                e.getMessage(),
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    public final ResponseEntity<ExceptionResponse> handleForbiddenException(Exception e) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                httpStatus.value(),
                httpStatus.toString(),
                e.getMessage(),
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {UnauthorizedException.class})
    public final ResponseEntity<ExceptionResponse> handleUnauthorizedException(Exception e) {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                httpStatus.value(),
                httpStatus.toString(),
                e.getMessage(),
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {InternalErrorException.class})
    public final ResponseEntity<ExceptionResponse> handleInternalErrorException(Exception e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                httpStatus.value(),
                httpStatus.toString(),
                e.getMessage(),
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

    @ExceptionHandler(value = {GameAlreadyRunningException.class})
    public final ResponseEntity<ExceptionResponse> handleGameAlreadyRunningException(Exception e) {
        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                httpStatus.value(),
                httpStatus.toString(),
                e.getMessage(),
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
