package com.sample;

import com.sample.model.Person;
import com.sample.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> create(@RequestBody Person person) {
       return service.create(person);
    }

    @GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Person> findAll() {
        return service.findAll();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public ResponseEntity<Mono<Person>> findById(@PathVariable("id") Long id) {
        Mono<Person> person = service.findById(id);
        return new ResponseEntity<Mono<Person>>(person, person != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Person> update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id).subscribe();
    }
    
}
