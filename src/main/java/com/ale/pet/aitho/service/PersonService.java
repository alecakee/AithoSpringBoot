package com.ale.pet.aitho.service;

import com.ale.pet.aitho.dao.exceptions.InvalidRequestException;
import com.ale.pet.aitho.dao.exceptions.NoNamesFoundException;

public interface PersonService {
    String getNamesByChar(String letter) throws InvalidRequestException, NoNamesFoundException;
}
