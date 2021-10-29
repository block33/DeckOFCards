package com.deckofcards.services;

import com.deckofcards.dtos.PlayerDto;
import com.deckofcards.models.Card;
import com.deckofcards.models.Player;

import java.util.List;

public interface PlayerService {
    void addPlayer(Player player);
    void removePlayer(String playerId);
    Player getPlayer(String playerId);
    List<Player> getPlayers();
    void sortPlayers(List<PlayerDto> playerDtos);
    List<Card> getHand(String playerId);
    void resetPlayers();
}
