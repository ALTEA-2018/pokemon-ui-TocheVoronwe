package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ModelAttribute(value = "user")
    public Object principal(){
        var context = SecurityContextHolder.getContext();
        return context.getAuthentication().getPrincipal();
    }

}