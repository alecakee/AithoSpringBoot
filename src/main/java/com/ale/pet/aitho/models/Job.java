package com.ale.pet.aitho.models;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    long job_id;

    String job_name;

    public Job(){}

    public Job(Long id, String job_name){
        this.job_id = id;
        this.job_name = job_name;
    }

    @OneToOne(mappedBy = "job")
    private Person person;

    public Long getId() {
        return job_id;
    }

    public void setId(Long id) {
        this.job_id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

}
