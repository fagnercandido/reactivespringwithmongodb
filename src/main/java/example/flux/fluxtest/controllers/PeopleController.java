package example.flux.fluxtest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import example.flux.fluxtest.repositories.People;
import example.flux.fluxtest.repositories.PeopleRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping
    public Flux<People> findAll() {
        return peopleRepository.findAll();
    }

    @GetMapping("/name")
    public Flux<People> findByName(@RequestParam String name) {
        return peopleRepository.findByName(name);
    }

    @GetMapping("/{id}")
    public Mono<People> findById(@PathVariable String id) {
        return peopleRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<People> create(@RequestBody People people) {
        return peopleRepository.save(people);
    }

    
}