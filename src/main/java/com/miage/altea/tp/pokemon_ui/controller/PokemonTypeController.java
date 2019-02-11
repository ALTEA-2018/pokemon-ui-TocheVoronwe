package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokemonTypeController {
    PokemonTypeService pokemonTypeService;
    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        var modelAndView = new ModelAndView("pokedex");
        modelAndView.addObject("pokemonTypes", pokemonTypeService.listPokemonsTypes());
        return modelAndView;
    }

    void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

}