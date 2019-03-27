package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {
    TrainerService trainerService;

    @GetMapping("/trainers")
    public ModelAndView trainer(){
        var modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers", trainerService.listTrainers());
        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        var connectedUser = getConnectedUsername();
        var modelAndView = new ModelAndView("profile");
        modelAndView.addObject("trainers", trainerService.getTrainer(connectedUser));
        return modelAndView;

    }

    @Autowired()
    void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    private String getConnectedUsername() {
        var context = SecurityContextHolder.getContext();
        User principal = (User)context.getAuthentication().getPrincipal();
        return principal.getUsername();
    }

}