package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DogService {
@Autowired
    private DogRepository dogRepository;
    public List<String> retrieveDogBreed(){

        return dogRepository.getBreedDetails();
    }

    public List<String> retrieveDogNames(){return dogRepository.getNameDetails();}

    public String retrieveDogBreedById(long id) throws DogNotFoundException {

        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.getBreedById(id));

        String Breed = optionalBreed.orElseThrow(DogNotFoundException::new);

       return Breed;

    }

    public List<Dog> retrieveAllDogs() {

        return (List<Dog>) dogRepository.findAll();
    }
}
