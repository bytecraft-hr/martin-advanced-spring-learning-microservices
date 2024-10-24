package com.example.people.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import java.util.List;
import com.example.people.dto.ProjectDTO;

@Service
public class ProjectServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<ProjectDTO> getProjectsForPerson(Integer personId) {
        String url = "http://localhost:8082/api/projects/person/" + personId;
        ResponseEntity<List<ProjectDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ProjectDTO>>() {}
        );
        return response.getBody();
    }
    
    public void addProjectToPerson(Integer personId, ProjectDTO projectDTO) {
        restTemplate.postForObject(
            "http://localhost:8082/api/projects/person/{personId}/add", 
            projectDTO, 
            Void.class, 
            personId
        );
    }

    public void removeProjectFromPersonByName(Integer personId, String name) {
        String url = String.format("http://project-service/api/projects/person/%d/project?name=%s", personId, name);
        restTemplate.delete(url);
    }


}

