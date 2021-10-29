package com.deckofcards.deckofcards.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Game extends BaseEntity {
    private GameDeck gameDeck = new GameDeck();
}
