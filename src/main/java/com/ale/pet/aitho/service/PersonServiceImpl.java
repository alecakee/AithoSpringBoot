package com.ale.pet.aitho.service;

import com.ale.pet.aitho.dao.exceptions.InvalidRequestException;
import com.ale.pet.aitho.dao.exceptions.NoNamesFoundException;
import com.ale.pet.aitho.models.Person;
import com.ale.pet.aitho.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository person;

    @Override
    public String getNamesByChar(String letter) throws InvalidRequestException, NoNamesFoundException {
        String result;
        if (letter.matches("[a-zA-Z]")) {
            List<String> filter = person
                    .findAll()
                    .stream()
                    .filter(p -> p.getName().startsWith(letter))
                    .toList()
                    .stream()
                    .map(Person::getName).toList();

            result = String.join(", ", filter);
        }
        else {throw new InvalidRequestException("invalid input");}
        if (!result.isEmpty()) {return result;}
        else {throw new NoNamesFoundException("no names found");}
    }
}