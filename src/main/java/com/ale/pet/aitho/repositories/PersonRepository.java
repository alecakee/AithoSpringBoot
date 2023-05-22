package com.ale.pet.aitho.repositories;

import com.ale.pet.aitho.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    @Query(value = "SELECT person.name, person.surname, person.age, job.job_name FROM person INNER JOIN job ON person.name=:name AND person.surname=:surname AND person.job_id=job.job_id", nativeQuery = true)
    List<String> findPersonJob(@Param("name") String name, @Param("surname") String surname);
}
