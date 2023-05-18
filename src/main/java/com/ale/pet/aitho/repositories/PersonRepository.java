package com.ale.pet.aitho.repositories;

import com.ale.pet.aitho.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
