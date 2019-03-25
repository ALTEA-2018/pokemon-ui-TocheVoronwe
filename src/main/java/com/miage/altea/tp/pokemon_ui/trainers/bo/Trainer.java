package com.miage.altea.tp.pokemon_ui.trainers.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Trainer {
    public String name;
    public List<TeamMember> team;
    public String password;
}
