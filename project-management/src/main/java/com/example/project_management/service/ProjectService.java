package com.example.project_management.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.project_management.repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.project_management.dto.ProjectDTO;
import com.example.project_management.model.Project;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectsByPersonId(Long personId) {
        return projectRepository.findByPersonId(personId);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }


    public void addProjectToPerson(Long personId, ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setPersonId(personId);  // Obavezno postavite personId
        projectRepository.save(project);
    }
    

    public void deleteProjectFromPersonByName(Integer personId, String name) {
        System.out.println("Deleting project: " + name + " for personId: " + personId);
        
        Optional<Project> project = projectRepository.findByNameAndPersonId(name, personId);
        if (project.isPresent()) {
            projectRepository.delete(project.get());
            System.out.println("Project deleted successfully.");
        } else {
            System.out.println("Project not found for personId: " + personId + " and name: " + name);
            throw new EntityNotFoundException("Project not found for this person.");
        }
    }
    
    


}
