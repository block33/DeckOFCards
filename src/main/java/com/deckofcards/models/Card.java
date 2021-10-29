package com.deckofcards.models;

import com.deckofcards.enums.CardSuit;
import com.deckofcards.enums.CardValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Card {
    private CardValue value;
    private CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }
}
