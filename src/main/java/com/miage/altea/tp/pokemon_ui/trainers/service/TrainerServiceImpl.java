package com.miage.altea.tp.pokemon_ui.trainers.service;

import com.miage.altea.tp.pokemon_ui.pokemonTypes.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.bo.TeamMember;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    private String url;

    private RestTemplate restTemplate;
    private PokemonTypeService pokemonTypeService;

    public List<Trainer> listTrainers() {
        var res = restTemplate.getForObject(url + "/trainers", Trainer[].class);
        List<Trainer> trainers = new ArrayList<>();
        if (res != null) {
            trainers = Arrays.asList(res);
            trainers.parallelStream().flatMap(trainer -> trainer.team.stream()).forEach(pokemon ->
                    setPokemonType(pokemon));
        }
        return trainers;
    }

    public Trainer getTrainer(String name) {
        var trainer = restTemplate.getForObject(url + "/trainers/" + name, Trainer.class);
        if (trainer != null) {
            trainer.team.forEach(teamMember -> setPokemonType(teamMember));
        }
        return trainer;

    }

    private void setPokemonType(TeamMember teamMember) {
        var pokemon = this.pokemonTypeService.getPokemonById(teamMember.getPokemonType());
        if (pokemon != null)
            teamMember.setType(pokemon);
    }

    @Autowired()
    @Qualifier("trainerApiRestTemplate")
    void setTrainerApiRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String trainerServiceUrl) {
        this.url = trainerServiceUrl;
    }
}