package com.deckofcards.deckofcards.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class GameDeck {
    private UUID gameId;
    private List<Card> cards = new ArrayList<>();
    private boolean isShuffled = false;
}
