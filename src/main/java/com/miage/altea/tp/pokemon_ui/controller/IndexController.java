package com.miage.altea.tp.pokemon_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("index")
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}