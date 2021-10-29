package com.deckofcards.deckofcards.services;

import com.deckofcards.deckofcards.enums.CardSuit;
import com.deckofcards.deckofcards.models.Card;
import com.deckofcards.deckofcards.models.GameDeck;
import java.util.List;
import java.util.Map;

public interface DeckService {
    void createDeck(GameDeck gameDeck);
    void dealCards(GameDeck gameDeck, List<Card> hand, int numberOfCards);
    void shuffleGameDeck(GameDeck gameDeck);
    Map<CardSuit, Integer> getNumOfUndealtCardsPerSuit(GameDeck gameDeck);
    Object getNumOfEachCard();
}
