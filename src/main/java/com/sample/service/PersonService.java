package com.sample.service;

import com.sample.dao.PersonRepository;
import com.sample.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Mono<Person> findById(Long id) {
        return repository.findById(id);
    }

    public Mono<Person> create(Person person) {
        return repository.save(person);
    }

    public Mono<Person> update(Person person) {
        return repository.save(person);
    }

    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }

    public Flux<Person> findAll() {
        return repository.findAll();
    }
    
}
