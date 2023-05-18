package com.ale.pet.aitho.models;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @Column(name = "user_id")
    private String user_id;
    private String name;
    private String surname;
    private int age;

    public Person(String id, String name, String surname, int age) {
        this.user_id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_job_id")
    private Job job;

    public Person(){}

    public String getId() {
        return user_id;
    }

    public void setId(String id) {
        this.user_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
