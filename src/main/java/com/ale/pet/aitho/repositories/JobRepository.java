package com.ale.pet.aitho.repositories;

import com.ale.pet.aitho.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
