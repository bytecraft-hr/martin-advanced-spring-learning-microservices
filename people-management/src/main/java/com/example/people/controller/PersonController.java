package com.example.people.controller;

import com.example.people.model.Person;
import com.example.people.service.PersonService;
import com.example.people.dto.PersonDTO;
import com.example.people.dto.PersonWithDetailsDTO;
import com.example.people.dto.ProjectDTO;
import com.example.people.dto.SkillDTO;
import com.example.people.client.SkillServiceClient;
import com.example.people.client.ProjectServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private SkillServiceClient skillServiceClient;

    @Autowired
    private ProjectServiceClient projectServiceClient;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPeople() {
        List<PersonDTO> peopleDTO = personService.getAllPeopleDTO();
        return ResponseEntity.ok(peopleDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonWithDetailsDTO> getPersonById(@PathVariable("id") Integer id) {
        PersonDTO personDTO = personService.getPersonById(id);

        List<SkillDTO> skillDTOs = skillServiceClient.getSkillsForPerson(id);
        List<ProjectDTO> projectDTOs = projectServiceClient.getProjectsForPerson(id);
    
        List<String> skills = skillDTOs.stream()
                                       .map(SkillDTO::getName)
                                       .collect(Collectors.toList());
    
        List<String> projects = projectDTOs.stream()
                                           .map(ProjectDTO::getName)
                                           .collect(Collectors.toList());
    
        PersonWithDetailsDTO personWithDetailsDTO = new PersonWithDetailsDTO(
            personDTO.getFirstName(),
            personDTO.getLastName(),
            personDTO.getEmail(),
            skills,
            projects
        );
    
        return ResponseEntity.ok(personWithDetailsDTO);
    }
    

    
    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody Person person) {
        try {
            Person savedPerson = personService.savePerson(person);
            PersonDTO personDTO = new PersonDTO(savedPerson);
            return ResponseEntity.status(HttpStatus.CREATED).body(personDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable("id") int id) {
       

        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable("id") Integer id, @RequestBody Person updatedPerson) {
        try {
            Person existingPerson = personService.findById(id);
            if (existingPerson == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person with ID " + id + " not found.");
            }
    
            existingPerson.setFirstName(updatedPerson.getFirstName());
            existingPerson.setLastName(updatedPerson.getLastName());
            existingPerson.setEmail(updatedPerson.getEmail());
    
            Person savedPerson = personService.savePerson(existingPerson);
    
            PersonDTO personDTO = new PersonDTO(savedPerson);
            return ResponseEntity.ok("Person successfully updated "+personDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating person with ID " + id);
        }
    }
    





@PostMapping("/{id}/skills")
public ResponseEntity<Void> addSkillToPerson(@PathVariable("id") Integer personId, @RequestBody SkillDTO skillDTO) {
    skillServiceClient.addSkillToPerson(personId, skillDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}


@PostMapping("/{id}/projects")
public ResponseEntity<Void> addProjectToPerson(@PathVariable("id") Integer personId, @RequestBody ProjectDTO projectDTO) {
    projectServiceClient.addProjectToPerson(personId, projectDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
}








@DeleteMapping("/{id}/projects")
public ResponseEntity<Void> removeProjectFromPerson(@PathVariable("id") Integer personId, @RequestParam String name) {
    try {
        projectServiceClient.removeProjectFromPersonByName(personId, name);
        return ResponseEntity.noContent().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}


}
