package com.ale.pet.aitho.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    @Getter
    private Long userId;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String surname;

    @Getter @Setter
    private int age;

    public Person(Long id, String name, String surname, int age) {
        this.userId = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_job_id")
    private Job job;

    public Job getJob() {
        return job;
    }

    public Person(){}
}
