package com.ale.pet.aitho.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private Long userId;
    private String name;
    private String surname;
    private int age;

    @ManyToOne
    @JoinColumn(name = "jobId")
    private Job job;

    public Job getJob() {
        return job;
    }
}
