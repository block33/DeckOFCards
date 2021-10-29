package com.deckofcards.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class GameDeck {
    private List<Card> cards = new ArrayList<>();
    private boolean isShuffled = false;
}
