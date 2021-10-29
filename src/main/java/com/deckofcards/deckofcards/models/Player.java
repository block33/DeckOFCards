package com.deckofcards.deckofcards.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Player extends BaseEntity {
    private String name;
    private List<Card> hand = new ArrayList<>();
}
