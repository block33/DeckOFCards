package com.deckofcards.services;

import com.deckofcards.enums.CardSuit;
import com.deckofcards.models.*;
import com.deckofcards.models.Card;
import com.deckofcards.models.Deck;
import com.deckofcards.models.GameDeck;
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
        while(counter < maxToDeal) {
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
    public Map<CardSuit, Integer> getNumOfUndealtCardsPerSuit(GameDeck gameDeck) {
        Map<CardSuit, Integer> countUndealtSuits = new HashMap<>();

        List<Card> remainingCards = gameDeck.getCards();
        for(CardSuit suit : CardSuit.values()) {
            countUndealtSuits.put(suit, 0);
            for(Card card : remainingCards) {
                if(card.getSuit().equals(suit))
                    countUndealtSuits.put(suit, countUndealtSuits.get(suit) + 1);
            }
        }
        return countUndealtSuits;
    }

    @Override
    public Object getNumOfEachCard() {
        return null;
    }
}
