package com.example.project_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.stream.Collectors;
import com.example.project_management.service.ProjectService;
import com.example.project_management.model.Project;
import com.example.project_management.dto.ProjectDTO2;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

 @GetMapping
public ResponseEntity<List<ProjectDTO2>> getAllProjects() {
    List<Project> projects = projectService.getAllProjects();
    List<ProjectDTO2> projectDTOs = projects.stream()
                                           .map(ProjectDTO2::new)
                                           .collect(Collectors.toList());
    return ResponseEntity.ok(projectDTOs);
}



    @GetMapping("/person/{personId}")
    public List<Project> getProjectsForPerson(@PathVariable("personId") Long personId) {
        return projectService.getProjectsByPersonId(personId);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        // Osiguraj da personId nije proslijeđen
        project.setPersonId(null);
        return projectService.saveProject(project);
    }
    

    @DeleteMapping("/person/{personId}/project")
    public ResponseEntity<String> deleteProjectFromPersonByName(@PathVariable Integer personId, @RequestParam("name") String name) {
        try {
            System.out.println("Attempting to delete project: " + name + " for personId: " + personId);
            projectService.deleteProjectFromPersonByName(personId, name);
            return ResponseEntity.ok("Project '" + name + "' successfully deleted for personId " + personId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting project '" + name + "' for personId " + personId);
        }
    }
    
    
    
    
    
}
