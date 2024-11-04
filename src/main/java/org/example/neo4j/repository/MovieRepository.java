package org.example.neo4j.repository;

import org.example.neo4j.dao.MovieEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MovieRepository extends ReactiveNeo4jRepository<MovieEntity,String> {
    Mono<MovieEntity> findOneByTitle(String title);
}
