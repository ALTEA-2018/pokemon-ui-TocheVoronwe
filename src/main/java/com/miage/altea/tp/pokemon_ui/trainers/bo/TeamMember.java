package com.miage.altea.tp.pokemon_ui.trainers.bo;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMember {
    int id;
    int pokemonType;
    int level;
    PokemonType type;
}
