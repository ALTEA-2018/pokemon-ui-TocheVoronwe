package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();

    PokemonType getPokemonById(int id);
    void setRestTemplate(RestTemplate restTemplate);
}