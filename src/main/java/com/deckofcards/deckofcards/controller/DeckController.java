package com.deckofcards.deckofcards.controller;

import com.deckofcards.deckofcards.exceptions.InternalErrorException;
import com.deckofcards.deckofcards.models.Deck;
import com.deckofcards.deckofcards.services.DeckService;
import com.deckofcards.deckofcards.services.GameService;
import com.deckofcards.deckofcards.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/decks")
@RestController
@RequiredArgsConstructor
@Slf4j
public class DeckController {

    private final GameService gameService;
    private final PlayerService playerService;
    private final DeckService deckService;

    @PostMapping("/create-deck")
    @ApiOperation(value = "Creates a deck and adds to the current game deck.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Deck of 52 cards successfully created and added to the game deck."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<Deck> createDeck() {
        if(!gameService.gameExists())
            throw new InternalErrorException("The game was not yet launched. Please launch a game before creating a deck.");

        deckService.createDeck(gameService.getCurrentGame().getGameDeck());
        return null;
    }

    @PostMapping("/deal-cards")
    @ApiOperation(value = "Creates a deck and adds to the current game deck.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cards were successfully dealt to player."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<Deck> dealCards(@RequestParam String playerId, @RequestParam int numCards) {
        if(!gameService.gameExists())
            throw new InternalErrorException("The game was not yet launched. Please launch a game before dealing cards.");

        deckService.dealCards(gameService.getCurrentGame().getGameDeck(),
                playerService.getHand(playerId),
                numCards);
        return null;
    }

    @PostMapping("/shuffle")
    @ApiOperation(value = "Creates a deck and adds to the current game deck.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cards were successfully dealt to player."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<Deck> shuffleCards() {
        if(!gameService.gameExists())
            throw new InternalErrorException("The game was not yet launched. Please launch a game before dealing cards.");

        deckService.shuffleGameDeck(gameService.getCurrentGame().getGameDeck());
        return null;
    }

    @GetMapping("/get-remaining-suits")
    @ApiOperation(value = "Creates a deck and adds to the current game deck.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cards were successfully dealt to player."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<Object> getRemainingSuits() {
        if(!gameService.gameExists())
            throw new InternalErrorException("The game was not yet launched. Please launch a game before dealing cards.");

        if(gameService.getCurrentGame().getGameDeck().getCards().size() == 0)
            throw new InternalErrorException("You must add a deck before using this operation. Please launch the create deck first.");

        deckService.getNumOfUndealtCardsPerSuit(gameService.getCurrentGame().getGameDeck());
        return null;
    }
}
