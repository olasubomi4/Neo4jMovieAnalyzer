package org.example.neo4j.service;
import org.example.neo4j.dao.MovieEntity;
import org.example.neo4j.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Flux<MovieEntity> findAllMovies() {
        return movieRepository.findAll();
    }

    public Mono<MovieEntity> save(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }

    public Mono<MovieEntity> findMovieByTitle(String title) {
        return movieRepository.findOneByTitle(title);
    }

    public Mono<Void> deleteMovieById(String title) {
        return movieRepository.deleteById(title);
    }
}
