package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository <Dog, Id>{

    @Query("select d.id , d.breed from Dog d")
    List<String> getBreedDetails();

    @Query("select n.id , n.name from Dog n")
    List<String> getNameDetails();

    @Query("select b.id, b.breed from Dog b where b.id=:id")
    String getBreedById(long id);
}
