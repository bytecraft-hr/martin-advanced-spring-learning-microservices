package com.example.people.dto;
import com.example.people.model.Person; 



public class PersonDTO {
    private int personId;
    private String firstName;
    private String lastName;
    private String email;

    public PersonDTO(Person person) {
        this.personId = person.getPersonById();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.getEmail();
    }

    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}

