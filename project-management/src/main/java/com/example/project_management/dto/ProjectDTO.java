package com.example.project_management.dto;
import com.example.project_management.model.Project;

public class ProjectDTO {
    private String name;
    private String description;

    public ProjectDTO(Project project) {
        this.name = project.getName();
        this.description = project.getDescription();
    }

    public ProjectDTO() {}


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
