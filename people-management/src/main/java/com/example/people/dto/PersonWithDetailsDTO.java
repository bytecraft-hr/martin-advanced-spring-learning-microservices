package com.example.people.dto;

import java.util.List;

public class PersonWithDetailsDTO {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> skills;
    private List<String> projects; 

    // Constructor
    public PersonWithDetailsDTO(String firstName, String lastName, String email, List<String> skills, List<String> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skills = skills;
        this.projects = projects;  
    }

   

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public List<String> getSkills() {
    return skills;
}

public void setSkills(List<String> skills) {
    this.skills = skills;
}
 
public List<String> getProjects() {
    return projects;
}

public void setProjects(List<String> projects) {
    this.projects = projects;
}
}
