package com.miage.altea.tp.pokemon_ui.trainers.bo;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Trainer {
    public String Name;
    public List<PokemonType> team;
    public String password;
}
