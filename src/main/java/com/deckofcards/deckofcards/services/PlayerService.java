package com.deckofcards.deckofcards.services;

import com.deckofcards.deckofcards.dtos.PlayerDto;
import com.deckofcards.deckofcards.models.Card;
import com.deckofcards.deckofcards.models.Player;
import java.util.List;

public interface PlayerService {
    void addPlayer(Player player);
    void removePlayer(String playerId);
    Player getPlayer(String playerId);
    List<Player> getPlayers();
    void sortPlayers(List<PlayerDto> playerDtos);
    List<Card> getHand(String playerId);
}
