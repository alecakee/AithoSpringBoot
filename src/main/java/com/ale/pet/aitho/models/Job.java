package com.ale.pet.aitho.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    String id;

    String job_name;

    public Job(){}

    public Job(String id, String job_name){
        this.id = id;
        this.job_name = job_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

}
