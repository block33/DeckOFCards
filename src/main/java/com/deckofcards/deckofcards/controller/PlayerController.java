package com.deckofcards.deckofcards.controller;

import com.deckofcards.deckofcards.dtos.PlayerDto;
import com.deckofcards.deckofcards.exceptions.CustomExceptionHandler;
import com.deckofcards.deckofcards.exceptions.InternalErrorException;
import com.deckofcards.deckofcards.exceptions.RessourceNotFoundException;
import com.deckofcards.deckofcards.mappers.PlayerMapper;
import com.deckofcards.deckofcards.models.Card;
import com.deckofcards.deckofcards.models.Player;
import com.deckofcards.deckofcards.services.GameService;
import com.deckofcards.deckofcards.services.PlayerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/players")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;
    private final GameService gameService;

    @PostMapping("/add")
    @ApiOperation(value = "Add a player to the game session")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Player successfully added."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<Player> addPlayer(@RequestBody PlayerDto playerDto) {
        if(!gameService.gameExists())
            throw new InternalErrorException("The game was not yet launched. Please launch a game before adding a player.");

        Player player = playerMapper.convertToPlayer(playerDto);
        playerService.addPlayer(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @GetMapping("/getPlayers")
    @ApiOperation(value = "Get list of all players with they respective hand.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Player successfully added."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<List<PlayerDto>> getPlayers() {
        if(!gameService.gameExists())
            throw new InternalErrorException("ERROR - The game was not yet launched. Please launch a game before adding a player.");

        if(playerService.getPlayers().size() == 0)
            throw new RessourceNotFoundException("ERROR - You need to add a player before.");

        List<PlayerDto> playersDto = new ArrayList<>();
        playerService.getPlayers()
                .stream()
                .forEach(player -> playersDto.add(playerMapper.convertToPlayerDto(player)));
        return new ResponseEntity<>(playersDto, HttpStatus.OK);
    }

    @GetMapping("/getPlayer/{playerId}")
    @ApiOperation(value = "Get list of all players with they respective hand.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Player successfully added."),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable String playerId) {
        if(!gameService.gameExists())
            throw new InternalErrorException("ERROR - The game was not yet launched. Please launch a game before adding a player.");

        if(playerService.getPlayers().size() == 0)
            throw new RessourceNotFoundException("ERROR - You need to add a player before.");

        Player player = playerService.getPlayer(playerId);
        PlayerDto playerDto = playerMapper.convertToPlayerDto(player);
        return new ResponseEntity<>(playerDto, HttpStatus.OK);
    }


    @DeleteMapping("/remove/{playerId}")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Player successfully removed"),
            @ApiResponse(code = 500, message = "")
    })
    @ResponseBody
    public ResponseEntity<String> removePlayer(@PathVariable("playerId") String playerId) {
        playerService.removePlayer(playerId);
        return new ResponseEntity<>("Player successfully removed", HttpStatus.NO_CONTENT);
    }
}
