package com.deckofcards.deckofcards.services;

import com.deckofcards.deckofcards.models.Card;
import com.deckofcards.deckofcards.models.GameDeck;
import java.util.List;

public interface DeckService {
    void createDeck(GameDeck gameDeck);
    void dealCards(GameDeck gameDeck, List<Card> hand, int numberOfCards);
    void shuffleGameDeck(GameDeck gameDeck);
    Object getNumOfUndealtCardsPerSuit(GameDeck gameDeck);
    Object getNumOfEachCard();
}
