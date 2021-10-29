package com.deckofcards.models;

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
    private int count;
    private List<Card> hand = new ArrayList<>();
}
