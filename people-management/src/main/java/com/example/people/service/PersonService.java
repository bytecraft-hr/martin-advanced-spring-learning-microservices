package com.example.people.service;

import com.example.people.dto.PersonDTO;
import com.example.people.model.Person;
import com.example.people.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDTO> getAllPeopleDTO() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                     .map(PersonDTO::new)
                     .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(int id) {
        Person person = personRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Person not found"));
        return new PersonDTO(person);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }
    



    
}
