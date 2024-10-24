package com.example.people.client;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import java.util.List;
import com.example.people.dto.SkillDTO;

@Service
public class SkillServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<SkillDTO> getSkillsForPerson(Integer personId) {
        ResponseEntity<List<SkillDTO>> response = restTemplate.exchange(
            "http://localhost:8080/api/skills/person/{id}",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<SkillDTO>>() {},
            personId
        );
        
        List<SkillDTO> skills = response.getBody();
        
        if (skills == null) {
            return Collections.emptyList();
        }
        
        return skills;
    }






 // Nova metoda za dodavanje vještine osobi
 public void addSkillToPerson(Integer personId, SkillDTO skillDTO) {
    restTemplate.postForEntity(
        "http://localhost:8080/api/skills/person/{id}/add",
        skillDTO,
        Void.class,
        personId
    );
}



}



