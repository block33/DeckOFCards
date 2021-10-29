package com.deckofcards.services;

import com.deckofcards.models.Game;

public interface GameService {
    void createGame();
    void deleteGame();
    Game getCurrentGame();
    boolean gameExists();
}
