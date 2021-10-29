package com.deckofcards.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public abstract class BaseEntity {
    protected UUID id = UUID.randomUUID();
}
