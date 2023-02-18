package com.udacity.bootstrap.controller;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogNotFoundException;
import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

@GetMapping("/dogs")
public ResponseEntity<List<Dog>> allDogs(){

    List<Dog> list = dogService.retrieveAllDogs();
    return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
}

@GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> breedDetails(){

    List<String> list = dogService.retrieveDogBreed();
    return new ResponseEntity<List<String>>(list, HttpStatus.OK);
}

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String> >breedNames(){

    List<String> list= dogService.retrieveDogNames();

    return new ResponseEntity<List<String>>(list,HttpStatus.OK);
    }

    @GetMapping("/{id}/breeds")
    public ResponseEntity<String> breedDetailsById( @PathVariable long id) throws DogNotFoundException {

        String list= dogService.retrieveDogBreedById(id);

        return new ResponseEntity<String>(list, HttpStatus.OK);
    }




}
