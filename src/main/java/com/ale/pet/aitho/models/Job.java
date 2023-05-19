package com.ale.pet.aitho.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jobId")
    @Getter @Setter
    long jobId;

    @Getter @Setter
    String jobName;

    public Job(){}

    public Job(Long id, String job_name){
        this.jobId = id;
        this.jobName = job_name;
    }

    @OneToOne(mappedBy = "job")
    private Person person;

}
