package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@Controller
public class SecurityControllerAdvice {

    
    public Object principal(){
        var context = SecurityContextHolder.getContext();
        return context.getAuthentication().getPrincipal();
    }

}