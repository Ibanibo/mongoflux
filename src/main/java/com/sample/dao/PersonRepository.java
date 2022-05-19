package com.sample.dao;

import com.sample.model.Person;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person, Long> {
    
}
