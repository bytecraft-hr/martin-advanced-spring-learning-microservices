package com.example.skill_management.controller;


import com.example.skill_management.dto.SkillDTO;
import com.example.skill_management.model.Skill;
import com.example.skill_management.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/{skillId}")
    public ResponseEntity<SkillDTO> getSkillById(@PathVariable("skillId") Integer skillId) {
        SkillDTO skill = skillService.getSkillById(skillId); // Dohvati DTO iz servisa
        return ResponseEntity.ok(skill);
    }

   @GetMapping("/person/{personId}")
public List<SkillDTO> getSkillsForPerson(@PathVariable("personId") Long personId) {
    List<SkillDTO> skills = skillService.getSkillsByPersonId(personId);
    return skills;
}

    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        Skill savedSkill = skillService.saveSkill(skill);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSkill);
    }


    @PostMapping("/person/{id}/add")
    public ResponseEntity<String> addSkillToPerson(@PathVariable("id") Integer personId, @RequestBody SkillDTO skillDTO) {
        try {
            skillService.addSkillToPerson(personId, skillDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Skill '" + skillDTO.getName() + "' successfully added to personId " + personId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding skill to personId " + personId);
        }
    }
    


@DeleteMapping("/person/{personId}/skill")
public ResponseEntity<String> deleteSkillFromPersonByName(@PathVariable Integer personId, @RequestParam("name") String name) {
    try {
        skillService.deleteSkillFromPersonByName(personId, name);
        return ResponseEntity.ok("Skill '" + name + "' successfully deleted for personId " + personId);
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting skill");
    }
}



}

