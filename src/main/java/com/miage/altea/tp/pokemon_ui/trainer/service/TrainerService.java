package com.miage.altea.tp.pokemon_ui.trainer.service;

import com.miage.altea.tp.pokemon_ui.trainer.bo.Trainer;

import java.util.List;

public interface TrainerService {

    List<Trainer> listTrainers();
    Trainer getTrainer(String name);

}