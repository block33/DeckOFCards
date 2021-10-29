package com.deckofcards.deckofcards.enums;

public enum CardSuit {
    SPADES("spades"),
    HEARTS("hearts"),
    DIAMONDS("diamonds"),
    CLUBS("clubs");

    private final String name;

    CardSuit(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
