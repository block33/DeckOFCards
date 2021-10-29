package com.deckofcards.models;

import com.deckofcards.enums.CardSuit;
import com.deckofcards.enums.CardValue;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class Deck extends BaseEntity {
    private UUID gameDeckId;
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        for(CardSuit suit : CardSuit.values()) {
            for(CardValue value : CardValue.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }
}
