package com.deckofcards.enums;

public enum CardColor {
    BLACK("black"),
    RED("red");

    private final String name;

    CardColor(final String name) {
        this.name = name;
    }

    public final String getName() {
        return name;
    }
}
