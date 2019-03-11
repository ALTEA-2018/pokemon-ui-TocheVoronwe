package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {
    TrainerService trainerService;
    @GetMapping("/trainer")
    public ModelAndView trainer(){
        var modelAndView = new ModelAndView("trainer");
        modelAndView.addObject("trainers", trainerService.listTrainers());
        return modelAndView;
    }

    @Autowired()
    void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

}