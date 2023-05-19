package com.ale.pet.aitho.dao.requestModels.Person;

import lombok.Data;
import lombok.Getter;

@Data
public class AddPersonRequest {
    String name;
    String surname;
    int age;
}
