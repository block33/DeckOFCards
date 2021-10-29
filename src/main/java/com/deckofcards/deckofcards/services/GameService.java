package com.deckofcards.deckofcards.services;

import com.deckofcards.deckofcards.models.Game;

public interface GameService {
    void createGame();
    void deleteGame(String gameId);
    Game getCurrentGame();
    boolean gameExists();
}
