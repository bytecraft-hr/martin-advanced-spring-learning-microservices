package com.example.skill_management.service;

import com.example.skill_management.dto.SkillDTO;
import com.example.skill_management.model.Skill;
import com.example.skill_management.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.Optional; 
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public SkillDTO getSkillById(Integer skillId) {
        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Skill not found with id " + skillId));
        return new SkillDTO(skill);
    }

    public List<SkillDTO> getSkillsByPersonId(Long personId) {
        List<Skill> skills = skillRepository.findByPersonId(personId);
        return skills.stream().map(SkillDTO::new).collect(Collectors.toList());
    }
    

    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public void addSkillToPerson(Integer personId, SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setName(skillDTO.getName());
        skill.setPersonId(personId.longValue());
        skillRepository.save(skill);
    }


    public void deleteSkillFromPersonByName(Integer personId, String name) {
        Optional<Skill> skill = skillRepository.findByNameAndPersonId(name, personId);
        if (skill.isPresent()) {
            skillRepository.delete(skill.get());
            System.out.println("Skill deleted successfully.");
        } else {
            throw new EntityNotFoundException("Skill not found for personId: " + personId + " and name: " + name);
        }
    }
    
    

}
