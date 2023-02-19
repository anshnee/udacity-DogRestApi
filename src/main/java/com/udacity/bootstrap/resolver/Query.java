package com.udacity.bootstrap.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.bootstrap.Exception.DogNotFoundExceptionGraph;
import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import com.udacity.bootstrap.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogrepository;

    public Query(DogRepository dogrepository) {
        this.dogrepository = dogrepository;
    }

    public Iterable<Dog> findAllDogs(){

        return dogrepository.findAll();
    }

    public Dog findDogById(Long id) throws DogNotFoundException {

        Optional<Dog> optionalDog = dogrepository.findById(id);

        if(optionalDog.isPresent()){

            return optionalDog.get();
        }

        else{
            throw new DogNotFoundExceptionGraph("Dog not found ",id);
        }
    }
}
