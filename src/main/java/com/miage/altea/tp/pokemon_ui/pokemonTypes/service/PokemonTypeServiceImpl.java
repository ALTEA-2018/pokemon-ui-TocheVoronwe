package com.miage.altea.tp.pokemon_ui.pokemonTypes.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public List<PokemonType> listPokemonsTypes() {
        var res = restTemplate.getForObject(url + "/pokemon-types/", PokemonType[].class);
        List<PokemonType> pokemonType = new ArrayList<>();
        if (res != null)
             pokemonType = Arrays.asList(res);
        return pokemonType;
    }

    public List<PokemonType> listPokemonsWithLocale() {
        var locale = LocaleContextHolder.getLocaleContext().getLocale();
        var res = restTemplate.getForObject(url + "/pokemon-types/locale/" + locale.toString(), PokemonType[].class);
        List<PokemonType> pokemonType = new ArrayList<>();
        if (res != null)
             pokemonType = Arrays.asList(res);
        return pokemonType;
    }

    @Autowired()
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.url = pokemonServiceUrl;
    }
}