package com.deckofcards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class GameAlreadyRunningException extends RuntimeException {
    public GameAlreadyRunningException(String message) {
        super(message);
    }
}
