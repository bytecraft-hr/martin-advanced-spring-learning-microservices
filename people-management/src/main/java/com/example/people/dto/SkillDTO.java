package com.example.people.dto;
import com.example.people.model.Skill;



public class SkillDTO {
    private Long id;
    private String name;

    // Dodaj zadani konstruktor
    public SkillDTO() {
    }

    // Konstruktor koji prima Skill entitet
    public SkillDTO(Skill skill) {
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
