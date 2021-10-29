package com.deckofcards.deckofcards.services;

import com.deckofcards.deckofcards.models.Game;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
@Getter
@Setter
public class GameServiceImpl implements GameService {
    private Game game;

    @Override
    public void createGame() {
        game = new Game();
    }

    @Override
    public void deleteGame(String gameId) {
        game = null;
    }

    @Override
    public Game getCurrentGame() {
        return game;
    }

    @Override
    public boolean gameExists() {
        return game != null;
    }
}
