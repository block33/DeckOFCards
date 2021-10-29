package com.deckofcards.services;

import com.deckofcards.dtos.PlayerDto;
import com.deckofcards.models.Card;
import com.deckofcards.models.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Getter
@Setter
public class PlayerServiceImpl implements PlayerService {
    private List<Player> players = new ArrayList<>();

    @Override
    public void addPlayer(Player player) {
        if(players == null)
            players = new ArrayList<>();

        players.add(player);
    }

    @Override
    public void removePlayer(String playerId) {
        players.removeIf(player -> player.getId().toString().equals(playerId));
    }

    @Override
    public Player getPlayer(String playerId) {
        return players.stream().filter(player -> player.getId().toString().equals(playerId)).findFirst().get();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void sortPlayers(List<PlayerDto> playerDtos) {
        playerDtos.sort(Comparator.comparing(PlayerDto::getCount).reversed());
    }

    @Override
    public List<Card> getHand(String playerId) {
        return players.stream()
                .filter(p -> p.getId().toString().equals(playerId))
                .findFirst()
                .get()
                .getHand();
    }

    @Override
    public void resetPlayers() {
        players = null;
    }
}
