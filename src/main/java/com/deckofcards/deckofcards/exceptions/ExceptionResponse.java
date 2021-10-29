package com.deckofcards.deckofcards.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Setter
@Getter
public class ExceptionResponse {
    private final int code;
    private final String status;
    private final String message;
    private final OffsetDateTime timeStamp;
}
