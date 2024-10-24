package com.example.people.dto;


public class ProjectDTO {
    private Long id;
    private String name;

    // Constructor
    public ProjectDTO() {}


      public ProjectDTO(ProjectDTO projectDTO) {
        this.name = projectDTO.getName();
    }
    // Getters and setters
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
