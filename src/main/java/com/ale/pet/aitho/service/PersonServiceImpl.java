package com.ale.pet.aitho.service;

import com.ale.pet.aitho.models.Person;
import com.ale.pet.aitho.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository person;

    @Override
    public String getNamesByChar(String letter) {

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
        else{return "Error, input non valido";}

        if (!result.isEmpty()){
            return result;
        }
        else{
            return "Nessun record trovato";
        }
    }
}