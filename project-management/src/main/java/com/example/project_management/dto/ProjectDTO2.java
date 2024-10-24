package com.example.project_management.dto;
import com.example.project_management.model.Project;

public class ProjectDTO2 {
     
    private Long id;
    private String name;
    private String description;


    public ProjectDTO2(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
    }

    public ProjectDTO2() {}


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
