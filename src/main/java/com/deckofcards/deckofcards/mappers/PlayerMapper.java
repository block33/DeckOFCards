package com.deckofcards.deckofcards.mappers;

import com.deckofcards.deckofcards.dtos.PlayerDto;
import com.deckofcards.deckofcards.models.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "name", source = "playerDto.name")
    Player convertToPlayer(PlayerDto playerDto);

    @Mappings(value = {
            @Mapping(target = "playerId", expression = "java(getUUIDAsString(player.getId()))"),
            @Mapping(target = "name", source = "player.name"),
            @Mapping(target = "hand", source = "player.hand")
    })
    PlayerDto convertToPlayerDto(Player player);

    default String getUUIDAsString(UUID uuid) {
        return uuid.toString();
    }
}
