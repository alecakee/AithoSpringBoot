package com.ale.pet.aitho.api;

import com.ale.pet.aitho.dao.requestModels.Person.AddPersonRequest;
import com.ale.pet.aitho.models.Person;
import com.ale.pet.aitho.repositories.PersonRepository;
import com.ale.pet.aitho.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository person;
    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPersone(){
        return person.findAll();
    }

    @GetMapping("{id}")
    public Optional<Person> getPersona(@PathVariable String id){
        return person.findById(id);
    }

    @PostMapping
    public void addPersona(@RequestBody AddPersonRequest request){
        Person newPerson = new Person();
        newPerson.setName(request.getName());
        newPerson.setSurname(request.getSurname());
        newPerson.setAge(request.getAge());
        person.save(newPerson);
    }

    @GetMapping(value = "/people/letter/{letter}")
    public String listPersonaByChar(@PathVariable String letter){
        return personService.getNamesByChar(letter);
    }

    @GetMapping("/jobs/{name}/{surname}")
    public String getJobByPersona(@PathVariable(name = "name") String name, @PathVariable(name = "surname") String surname){
        return person.findPersonJob(name, surname).toString();
    }
}
