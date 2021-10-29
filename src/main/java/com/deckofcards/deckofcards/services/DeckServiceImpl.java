package com.deckofcards.deckofcards.services;

import com.deckofcards.deckofcards.enums.CardSuit;
import com.deckofcards.deckofcards.models.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Service
public class DeckServiceImpl implements DeckService {

    @Override
    public void createDeck(GameDeck gameDeck) {
        Deck newDeck  = new Deck();
        gameDeck.getCards().addAll(newDeck.getCards());
        for(Card card : gameDeck.getCards()) {
            System.out.println("suit: " + card.getSuit() + "value: " + card.getValue());
        }
        System.out.println("Cards count : " + gameDeck.getCards().size());
    }

    @Override
    public void dealCards(GameDeck gameDeck, List<Card> hand, int numCards) {
        final int maxToDeal = numCards > gameDeck.getCards().size() ? gameDeck.getCards().size() : numCards;

        int counter = 0;
        while(counter < numCards) {
            hand.add(gameDeck.getCards().remove(0));
            counter++;
        }
    }

    @Override
    public void shuffleGameDeck(GameDeck gameDeck) {
        List<Card> currentGameDeck = gameDeck.getCards();
        List<Card> shuffledGameDeck = new ArrayList<>();
        while(currentGameDeck.size() > 0) {
            int index = (int) (Math.random() *  currentGameDeck.size());
            shuffledGameDeck.add(currentGameDeck.remove(index));
        }
        gameDeck.setCards(shuffledGameDeck);
        for(Card card : gameDeck.getCards()) {
            System.out.println("suit: " + card.getSuit() + "value: " + card.getValue());
        }
        System.out.println("Cards count : " + gameDeck.getCards().size());
    }

    @Override
    public Map<String, Object> getNumOfUndealtCardsPerSuit(GameDeck gameDeck) {
        Map<CardSuit, Integer> cardsRemaining = new HashMap<>();

        List<Card> remainingCards = gameDeck.getCards();
        for(CardSuit suit : CardSuit.values()) {

        }

    }

    @Override
    public Object getNumOfEachCard() {
        return null;
    }
}
