package example.flux.fluxtest.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PeopleRepository extends ReactiveMongoRepository<People, String> {


    Flux<People> findByName(String name);

    Mono<People> findById(String id);
    
    

}