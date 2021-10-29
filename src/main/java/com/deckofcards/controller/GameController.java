package com.deckofcards.controller;

import com.deckofcards.exceptions.GameAlreadyRunningException;
import com.deckofcards.services.GameService;
import com.deckofcards.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/games")
@RestController
@RequiredArgsConstructor
@Slf4j
public class GameController {
    private final GameService gameService;
    private final PlayerService playerService;

    @ResponseBody
    @PostMapping("/create")
    @ApiOperation(value = "Create a game session")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Game successfully created"),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 409, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    public ResponseEntity<String> createGame() {
        if(gameService.gameExists())
            throw new GameAlreadyRunningException("Game was already created. You are limited to one session at a time.");

        gameService.createGame();
        return new ResponseEntity<>("Game successfully created", HttpStatus.CREATED);
    }

    @ResponseBody
    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete a game session")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Game successfully created"),
            @ApiResponse(code = 500, message = "")
    })
    public ResponseEntity<String> deleteGame(String gameId) {
        gameService.getCurrentGame().setGameDeck(null);
        playerService.resetPlayers();
        gameService.deleteGame();
        return new ResponseEntity<>("Game successfully deleted", HttpStatus.NO_CONTENT);
    }

}
