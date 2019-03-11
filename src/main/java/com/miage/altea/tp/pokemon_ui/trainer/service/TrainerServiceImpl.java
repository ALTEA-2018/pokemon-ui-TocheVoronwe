package com.miage.altea.tp.pokemon_ui.trainer.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainer.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Trainer> listTrainers() {
        var res = restTemplate.getForObject(url + "/trainers", Trainer[].class);
        List<Trainer> trainers = new ArrayList<>();
        if (res != null)
             trainers = Arrays.asList(res);
        return trainers;
    }

    public Trainer getTrainer(String name) {
        return restTemplate.getForObject(url + "/trainers/" + name, Trainer.class);

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