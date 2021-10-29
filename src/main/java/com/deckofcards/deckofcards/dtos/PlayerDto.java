package com.deckofcards.deckofcards.dtos;

import com.deckofcards.deckofcards.models.Card;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class PlayerDto {
    private String playerId;
    private String name;
    private List<Card> hand;
    private int count;
}
