package com.example.skill_management.dto;

import com.example.skill_management.model.Skill;
public class SkillDTO {
    private Long id;
    private String name;

    // Defaultni konstruktor potreban za Jackson
    public SkillDTO() {}

    // Konstruktor koji prima entitet Skill
    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
    }

    // Getter i setter metode
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
