package com.ale.pet.aitho.api;

import com.ale.pet.aitho.models.Person;
import com.ale.pet.aitho.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository person;
    public PersonController(PersonRepository person) {this.person = person;}

    @GetMapping
    public List<Person> getPersone(){
        return person.findAll();
    }

    @GetMapping("{id}")
    public Optional<Person> getPersona(@PathVariable String id){
        return person.findById(id);
    }

    record addPersonRequest(String user_id, String name, String surname, int age){}
    @PostMapping
    public void addPersona(@RequestBody addPersonRequest request){
        Person newPerson = new Person();
        newPerson.setId(request.user_id);
        newPerson.setName(request.name);
        newPerson.setSurname(request.surname);
        newPerson.setAge(request.age);
        person.save(newPerson);
    }
}
