package com.udacity.bootstrap.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.bootstrap.Exception.BreedNotFoundException;
import com.udacity.bootstrap.Exception.DogNotFoundExceptionGraph;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed (String breed){

        Iterable<Dog> allDogs = dogRepository.findAll();

        boolean deleted =false;
        for(Dog d : allDogs) {
            if (d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }
            if (!deleted){
                throw new BreedNotFoundException("Breed not found",breed);
            }

        return deleted;

    }

    public Dog updateDogName (String NewName , Long id){

        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog= optionalDog.get();

            dog.setName(NewName);
            dogRepository.save(dog);
            return dog;
        }
        else{
            throw new DogNotFoundExceptionGraph("Dog not found" ,id);
        }


    }
}
